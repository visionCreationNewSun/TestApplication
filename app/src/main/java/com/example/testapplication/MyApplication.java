package com.example.testapplication;

import android.app.Application;

/**
 *   url등의 정보를 담기 위한 클래스
 */
public class MyApplication extends Application {

    // API용 URL
    public static String testUrl = "http://54.180.174.214:7711/api/test/follow/user";

    public String getUrl(){
        return testUrl;
    }
}
