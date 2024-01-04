package com.tjetc.enums;

public enum MsgActionEnum {
    /** 第一次(或重连)初始化连接 */
    CONNECT(1,"第一次(或重连)初始化连接"),
    /** 聊天消息 */
    CHAT(2,"聊天消息"),

    /** 客户端保持心跳 */
    KEEPALIVE(3,"客户端保持心跳"),
    BREAK(4,"退出");

    public final Integer type;
    public final String content;

    private MsgActionEnum(Integer type,String content) {
        this.type = type;
        this.content = content;
    }
}
