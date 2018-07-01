package com.wuzy.logger;

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

        L.e(throwable);
        mDefaultExceptionHandler.uncaughtException(thread, throwable);

    }
}
