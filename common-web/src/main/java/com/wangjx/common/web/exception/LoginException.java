package com.wangjx.common.web.exception;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/10/27
 * Time: 15:59
 */
public class LoginException extends RuntimeException {

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }
}
