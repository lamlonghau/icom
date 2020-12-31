package com.icommerce.product.core.shared;

public class LocalProfile {

    private static final ThreadLocal<String> user = new ThreadLocal<>();

    public static void setUserId(String value) {
        user.set(value);
    }

    public static String getUserId() {
        return user.get();
    }

    public static void clearUserId() {
        user.remove();
    }
}
