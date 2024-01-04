package com.tjetc.service;

public interface QuestionService {

    /**
     * 功能描述：解答完毕时，将聊天内容存进mysql，清空redis缓存
     * @param questionId 问题id
     * @param askId 提问方id
     * @param answerId 解答方id
     */
    void updateChatContent ( Integer questionId, Integer askId, Integer answerId );

    /**
     * 功能描述：查询历史聊天记录（从redis缓存中查询）
     * @param questionId 问题id
     * @param askId 提问方id
     * @param answerId 解答方id
     * @return 聊天信息的json字符串
     */
    String getChatContent ( Integer questionId, Integer askId, Integer answerId);

}
