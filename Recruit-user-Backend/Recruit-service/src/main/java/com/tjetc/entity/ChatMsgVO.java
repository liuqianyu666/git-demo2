package com.tjetc.entity;

import com.tjetc.enums.MsgSignFlagEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChatMsgVO extends ChatVO {

    /** 动作类型 */
    private Integer action;

    /** 消息签收状态 */
    private MsgSignFlagEnum signed;

}
