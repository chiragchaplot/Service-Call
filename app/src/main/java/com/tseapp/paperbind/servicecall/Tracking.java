package com.tseapp.paperbind.servicecall;

/**
 * Created by chiragchaplot on 4/3/15.
 */

import android.app.Application;
import android.content.Context;

public class Tracking extends Application {

    private static Context context;

    public static Context getAppContext() {
        return Tracking.context;
    }

    public void onCreate() {
        super.onCreate();
        Tracking.context = getApplicationContext();
    }
}