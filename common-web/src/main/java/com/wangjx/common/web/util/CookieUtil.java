package com.wangjx.common.web.util;

import javax.servlet.http.Cookie;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/1/18
 * Time: 10:47
 */
public class CookieUtil
{
    public static Cookie get(Cookie[] cookies, String name)
    {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }
}