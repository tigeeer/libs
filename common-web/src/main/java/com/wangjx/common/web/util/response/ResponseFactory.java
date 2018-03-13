package com.wangjx.common.web.util.response;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2016/11/23
 * Time: 11:50
 */
public class ResponseFactory {

    private static <T> Response<T> newResponse(int code, String msg) {
        return new Response<T>(code, msg, null);
    }

    private static <T> Response<T> newResponse(int code, String msg, T payload) {
        return new Response<>(code, msg, payload);
    }

    public static <T> Response<T> successResponse() {
        return newResponse(ResponseCode.SUCCESS, null);
    }

    public static <T> Response<T> successResponse(T payload) {
        Response<T> response = successResponse();
        response.setPayload(payload);

        return response;
    }

    public static <T> Response<T> exceptionResponse(int code , Exception e) {
        return newResponse(code, e.getMessage());
    }
}
