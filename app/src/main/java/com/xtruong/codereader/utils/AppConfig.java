package com.xtruong.codereader.utils;

/**
 * Created by truongtx on 8/10/2019
 */
public final class AppConfig {

    //Main URL
    private static String MAIN_URL = "http://192.168.0.102/android_login/";
    // Login URL
    public static String LOGIN_URL = MAIN_URL + "login.php";
    // Register URL
    public static String REGISTER_URL = MAIN_URL + "register.php";
    // OTP Verification
    public static String OTP_VERIFY_URL = MAIN_URL + "verification.php";
    // Forgot Password
    public static String RESET_PASS_URL = MAIN_URL + "reset-password.php";

}
