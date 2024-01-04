package com.tjetc.common;

/**
 * 统一返回前端的Json对象
 *
 * @param <T>
 */
public class JsonResult<T> {
    //0 代表成功，大于0代表失败,-1代表登录过期
    private int state;
    //失败的提示信息
    private String message;
    //返回的数据
    private T data;

    public JsonResult(int state, String message, T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
