package com.wangjx.common.util.codec;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: tigeeer
 * Date: 2017/1/3
 * Time: 15:35
 */
public class CodeUtil {

    private static final String B62T = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String B10T = "0123456789";

    /**
     * Generates a string of random chars from the B10T set.
     * @param num
     * Number of chars to generate.
     */
    public static String getB10t(final int num) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= num; i++) {
            stringBuilder.append(B10T.charAt(new Random().nextInt(B10T.length())));
        }

        return stringBuilder.toString();
    }

    /**
     * Generates a string of random chars from the B62T set.
     * @param num
     * Number of chars to generate.
     */
    public static String getB62t(final int num) {
        final StringBuilder stringBuilder = new StringBuilder();

        for (int i = 1; i <= num; i++) {
            stringBuilder.append(B62T.charAt(new Random().nextInt(B62T.length())));
        }

        return stringBuilder.toString();
    }
}
