package com.wangjx.common.util;

import java.util.regex.Pattern;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/10/17
 * Time: 16:06
 */
public class RegexUtil {

    public static boolean mobile(String mobile) {
        return matcher("^1[3,4,5,7,8][0-9]{9}$", mobile);
    }

    public static boolean email(String email) {
        return matcher("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", email);
    }

    public static boolean matcher(String regex, String input) {
        return Pattern.matches(regex, input);
    }
}
