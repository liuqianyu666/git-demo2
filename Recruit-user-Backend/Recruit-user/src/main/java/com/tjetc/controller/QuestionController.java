package com.tjetc.controller;

import com.tjetc.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 修改问题状态：聊天信息从redis保存到数据库（当结束此次解答时调用），status改为2
     */
    @PutMapping("/updateChatContent")
    public ResponseEntity<Object> updateChatContent(Integer questionId, Integer askId, Integer answerId){
        questionService.updateChatContent(questionId,askId,answerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 查询解决问题时的聊天记录（从redis缓存中查询）
     */
    @GetMapping("/getChatContent")
    public ResponseEntity<Object> getChatContent(Integer questionId,Integer askId,Integer answerId){
        return new ResponseEntity<>(questionService.getChatContent(questionId,askId,answerId),HttpStatus.OK);
    }

}