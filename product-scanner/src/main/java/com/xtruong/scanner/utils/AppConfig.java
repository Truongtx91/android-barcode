package com.xtruong.scanner.utils;

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

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "barcode.db";
    public static final String PREF_NAME = "barcode_pref";

    public static final long NULL_INDEX = -1L;

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    private AppConfig(){

    }
}
