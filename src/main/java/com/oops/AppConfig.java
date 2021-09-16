package com.oops;
//singelton class
public class AppConfig {
    private AppConfig() {

    }

    private static AppConfig obj;

    public static AppConfig getInstance() {
        return obj == null ? new AppConfig() : obj;
    }
}
