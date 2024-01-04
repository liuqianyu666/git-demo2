package com.tjetc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Question {
    private Long id;
    private Long askId;
    private Long answerId;
    private String context;
    private Date solveTime;
    private Integer status;
}
