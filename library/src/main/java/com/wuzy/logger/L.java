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

    public static void init(String tag, final boolean isLoggable, String packageName, String appName) {

        // 打印控制台日志
        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().tag(tag).build()) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return isLoggable;
            }
        });

        // 日志写到本地(error级别）
        Logger.addLogAdapter(new DiskLogAdapter(TxtFormatStrategy
                .newBuilder()
                .tag(tag)
                .build(packageName, appName)) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return priority == Logger.ERROR;
            }
        });

        // 崩溃日志收集
        Thread.setDefaultUncaughtExceptionHandler(new CrashHandler());
    }


    public static void d(String message, Object... args) {
        Logger.d(message, args);
    }

    public static void d(String message) {
        Logger.d(message);
    }

    public static void e(Throwable e) {
        e(e, null);
    }

    public static void e(Throwable e, String message) {
        Logger.e(e, message);
    }

    public static void json(String json) {
        Logger.json(json);
    }

}
