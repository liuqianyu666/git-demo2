package com.tjetc.entity;

import cn.hutool.core.annotation.Alias;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ChatVO implements Serializable {


    /** 消息id */
    private Integer questionId = 1;

    /**聊天信息类型*/
    private String chatMessageType;

    /**聊天内容*/
    private String content;

    /**发送方ID*/
    private Integer fromUserId;

    /**接收方ID*/
    private Integer toUserId;

    /**消息时间*/
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date dateTime;

}