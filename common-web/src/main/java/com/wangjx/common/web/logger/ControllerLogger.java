package com.wangjx.common.web.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/10/12
 * Time: 14:09
 */
@Aspect
@Component
public class ControllerLogger {
    private static final Logger logger = LoggerFactory.getLogger(ControllerLogger.class);

    @Pointcut(value = "execution(public * com.wangjx..controller..*.*(..))")
    public void log() {}

    @Before(value = "log()")
    public void logBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info(String.format("Input: [url=%s, http_method=%s, ip=%s, class_method=%s, args=%s]",
                request.getRequestURL().toString(),
                request.getMethod(),
                request.getRemoteAddr(),
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs())));
    }

    @AfterReturning(returning = "response", pointcut = "log()")
    public void logAfterReturning(JoinPoint joinPoint, Object response) {
        logger.info(String.format("Output: [class_method=%s, response=%s]",
                joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                response));
    }

    @AfterThrowing(throwing = "exception", pointcut = "log()")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
        if(exception != null) {
            logger.info(String.format("Error: [class_method=%s, exception=%s]",
                    joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName(),
                    exception.getMessage()));
            exception.printStackTrace();
        }
    }
}
