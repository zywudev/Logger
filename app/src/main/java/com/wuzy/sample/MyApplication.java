package com.wuzy.sample;

import android.app.Application;

import com.wuzy.logger.L;

/**
 * Created by wuzy on 2018/6/30.
 **/
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        L.init(getString(R.string.app_name),BuildConfig.DEBUG,getPackageName(),getString(R.string.app_name));
    }
}
