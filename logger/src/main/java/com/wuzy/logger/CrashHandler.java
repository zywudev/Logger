package com.wuzy.logger;

import okhttp3.OkHttpClient;

/**
 * Created by wuzy on 2018/06/27
 */

public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private Thread.UncaughtExceptionHandler mDefaultExceptionHandler;

    public CrashHandler() {
        this.mDefaultExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {

        HttpLogInterceptor logger = new HttpLogInterceptor();
        logger.setLevel(HttpLogInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(logger)
                .build();

        L.e(throwable);
        mDefaultExceptionHandler.uncaughtException(thread, throwable);

    }
}
