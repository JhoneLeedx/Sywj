package com.jhonlee.sywj.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class SharedPreferencesUtil {

    public static void setFlag(Context context,String key, boolean value){
        SharedPreferences preferences = context.getSharedPreferences("sharedpreferences",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public static boolean getFlag(Context context,String key){
        SharedPreferences preferences = context.getSharedPreferences("sharedpreferences",Context.MODE_PRIVATE);
        return preferences.getBoolean(key,false);
    }
}
