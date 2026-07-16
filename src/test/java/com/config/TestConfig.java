package com.config;

public final class TestConfig {

    public static final String LOGIN_URL = get("rekyc.login.url", "https://web.navia.co.in/login.php");
    public static final String HOME_URL = get("rekyc.home.url", "https://web.navia.co.in/index.php");
    public static final String CLIENT_CODE = get("rekyc.client.code", "63748379");
    public static final String PASSWORD = get("rekyc.password", "Navia@123");
    public static final String OTP_MAILBOX = get("rekyc.otp.mailbox", "naviatestingntp@yopmail.com");
    public static final String OTP_PROVIDER_URL = get("rekyc.otp.provider.url", "https://yopmail.com/");
    public static final String UPI_ID = get("rekyc.upi.id", "6374837965");

    private TestConfig() {
    }

    private static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null || value.trim().isEmpty()) {
            value = System.getenv(key.toUpperCase().replace('.', '_'));
        }
        return value == null || value.trim().isEmpty() ? defaultValue : value.trim();
    }
}
