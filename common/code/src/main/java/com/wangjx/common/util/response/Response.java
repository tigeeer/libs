package com.wangjx.common.util.response;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/1/3
 * Time: 15:35
 */
public class Response<T> {

    private int code;
    private String msg;
    private T payload;

    public Response(int code, String msg, T payload) {
        this.code = code;
        this.msg = msg;
        this.payload = payload;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDescription(String description) {
        this.msg = description;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", payload=" + payload +
                '}';
    }
}
