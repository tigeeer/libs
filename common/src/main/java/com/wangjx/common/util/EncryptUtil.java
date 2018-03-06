package com.wangjx.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/1/3
 * Time: 15:35
 */
public class EncryptUtil {

    public static String signature(String...params) {
        StringBuilder str = new StringBuilder();

        Arrays.sort(params);

        for(String param: params) {
            str.append(param);
        }

        return DigestUtils.sha1Hex(str.toString().getBytes());
    }
}
