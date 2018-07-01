# Logger

对 orhanobut 的 [Logger](https://github.com/orhanobut/logger) 库及 square 的 [okhttp-logging-interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) 库进行了修改和封装。

### 支持的功能

- Logcat 后台打印好看整洁的日志。
- error 级别和应用崩溃日志保存至本地文件。
- Logcat 后台打印 Http 日志，屏蔽了文件流打印乱码。

### 使用方法

1、引入依赖

```java
implementation 'com.wuzy:logger:1.0.0'
```

2、在 Application 中初始化：

```java
L.init(tag, isLoggable, packageName, appName);
```

其中 `tag`为日志标识，`isLoggable` 是否支持打印后台日志，`packageName` 为包名， `appName` 为应用名称。

error 级别和应用崩溃日志会自动保存至内部存储路径 `Android/data/packageName/log/` 路径下。

3、打印不同级别日志：

```java
L.d("message1");

L.w("message2");

L.i("message3");

L.json("{ \"key\": 3, \"value\": something}");

Map<String, String> map = new HashMap<>();
map.put("key", "value");
map.put("key1", "value2");

L.d(map);

L.e(new Throwable("error"));
```

