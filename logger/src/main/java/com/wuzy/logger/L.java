package com.wuzy.logger;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by wuzy on 2018/06/26
 */

public class L {

    private L() {
        throw new AssertionError();
    }

    /**
     * Log init， in application.
     */
    public static void init(String tag, final boolean isLoggable, String packageName, String appName) {

        // console log
        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().tag(tag).build()) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isLoggable;
            }
        });

        // write log to file (error)
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy
                .newBuilder()
                .tag(tag)
                .build(packageName, appName)) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return priority == Logger.ERROR;
            }
        });

        // crash log
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
    }



    public static void d(Object object) {
        Logger.d(object);
    }


    public static void d(String message, Object... args) {
        Logger.d(message, args);
    }

    public static void e(Throwable e) {
        e(e, null);
    }

    public static void e(String message, Object... args) {
        Logger.e(null, message, args);
    }

    public static void e(Throwable throwable, String message, Object... args) {
        Logger.e(throwable, message, args);
    }

    public static void i(String message, Object... args) {
        Logger.i(message, args);
    }

    public static void v(String message, Object... args) {
        Logger.v(message, args);
    }

    public static void w(String message, Object... args) {
        Logger.w(message, args);
    }

    public static void json(String json) {
        Logger.json(json);
    }

}
