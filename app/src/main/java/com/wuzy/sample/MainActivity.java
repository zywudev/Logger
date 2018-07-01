package com.wuzy.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wuzy.logger.L;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        L.d("message1");

        L.w("message2");

        L.i("message3");

        L.json("{ \"key\": 3, \"value\": something}");

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value2");

        L.d(map);

        L.e(new Throwable("error"));



    }
}
