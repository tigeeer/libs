package com.wangjx.common.web.exception;

import com.wangjx.common.web.util.response.ResponseCode;
import com.wangjx.common.web.util.response.ResponseFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/10/17
 * Time: 18:22
 */
@ControllerAdvice
public class CommonWebExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.getWriter().print(ResponseFactory.exceptionResponse(ResponseCode.RUNTIME_EXCEPTION, e));
        }else{
            response.sendRedirect("/error");
        }
    }

    @ExceptionHandler(LoginException.class)
    public void handleLoginException(HttpServletRequest request, HttpServletResponse response, Exception e) throws IOException {
        if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.getWriter().print(ResponseFactory.exceptionResponse(ResponseCode.LOGIN_EXCEPTION, e));
        }else{
            response.sendRedirect("/error");
        }
    }
}
