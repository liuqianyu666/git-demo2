package com.tjetc.dao;

import com.tjetc.entity.Question;

public interface QuestionMapper {
    Question findById(Integer questionId);
    Question save(Question question);
}
