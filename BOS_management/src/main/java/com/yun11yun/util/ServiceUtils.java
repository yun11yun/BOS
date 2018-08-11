package com.yun11yun.util;

public class ServiceUtils {

    private ServiceUtils() {}

    public static String likePredicateStringFrom(String param) {
        if (param == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        builder.append("%");
        builder.append(param);
        builder.append("%");
        return builder.toString();
    }
}
