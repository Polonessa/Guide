package com.example.lr5;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class Key extends Application {
    private final String key = "b135d9ab-df96-4d62-8b11-1ecf07da1503";
    @Override
    public void onCreate(){
        super.onCreate();
        MapKitFactory.setApiKey(key);
    }
}
