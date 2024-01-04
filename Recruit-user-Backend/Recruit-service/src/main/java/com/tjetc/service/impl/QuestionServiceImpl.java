package com.tjetc.service.impl;

import cn.hutool.json.JSONUtil;
import com.tjetc.dao.QuestionMapper;
import com.tjetc.entity.Question;
import com.tjetc.service.QuestionService;
import com.tjetc.util.ChatRedisUtil;
import com.tjetc.util.SpringContextHolder;
import com.tjetc.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateChatContent ( Integer questionId, Integer askId, Integer answerId ) {
        //实例化对象，从bean中取出  （还不理解）
        ChatRedisUtil chatRedisUtil = SpringContextHolder.getBean(ChatRedisUtil.class);
        //将用户未收到的消息，进行签证

        //将askId和answerId拼接成key，即房间号
        String key = chatRedisUtil.createChatNumber(questionId, askId, answerId);
        //得到缓存中的聊天信息的json字符串
        String chatContent = getChatContent(questionId, askId, answerId);
        //将数据存进数据库
        Question oldQuestion = questionRepository.findById(questionId);
        ValidationUtil.isNull(oldQuestion.getId(), "Question", "id", questionId);
        oldQuestion.setContext(chatContent);
        //设置问题状态为已解答
        oldQuestion.setStatus(2);
        oldQuestion.setSolveTime(new Timestamp(System.currentTimeMillis()));
        Question newQuestion = questionRepository.save(oldQuestion);
        if (newQuestion.getId() > 0) {
            //清除redis中缓存的数据
            chatRedisUtil.deleteCacheChatMessage(key);
        }
    }

    @Override
    public String getChatContent ( Integer questionId, Integer askId, Integer answerId) {
        //实例化对象，从bean中取出  （还不理解）
        ChatRedisUtil chatRedisUtil = SpringContextHolder.getBean(ChatRedisUtil.class);
        //将askId和answerId拼接成key，即房间号
        String key = chatRedisUtil.createChatNumber(questionId, askId, answerId);
        List<Object> chatList = chatRedisUtil.getCacheChatMessage(key);
        //将List数据转为json字符串，返回
        return JSONUtil.toJsonStr(chatList);
    }
}
