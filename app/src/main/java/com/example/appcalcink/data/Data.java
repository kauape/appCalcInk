package com.example.appcalcink.data;

import android.content.Context;
import android.content.SharedPreferences;

public class Data {
    private SharedPreferences mSharedPreferences;

    public Data(Context mContext) {
        this.mSharedPreferences = mContext.getSharedPreferences("qtdParedes", Context.MODE_PRIVATE);
    }

    public void storeString(String key, String value) {
        this.mSharedPreferences.edit().putString(key, value).apply();
    }

    public  String getStoredString(String key) {
        return this.mSharedPreferences.getString(key, "");
    }

    public String getNumWalls() {
        return  getStoredString("qtdParedes");
    }

    public void setNumWalls(String newValue) {
        this.storeString("qtdParedes", newValue);
    }
}
