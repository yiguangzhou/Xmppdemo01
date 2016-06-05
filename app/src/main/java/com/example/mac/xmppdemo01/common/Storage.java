package com.example.mac.xmppdemo01.common;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mac on 16/6/5.
 */
public class Storage {
    private final static  String STORAGE_FILE_NAME="chatclient.config";

    public static void putString(Context ctx, String key,String value){
        SharedPreferences sharedPreferences =getSharedPreferences(ctx);
        sharedPreferences.edit().putString(key,value).commit();
    }

    public static  String getString(Context ctx,String key,String... defaultVavlue){
     SharedPreferences sharedPreferences=getSharedPreferences(ctx);
     String dv="";
     for(String v:defaultVavlue){
         dv = v;
         break;
     }
        return sharedPreferences.getString(key,dv);
    }
    public static  void pubBoolean(Context ctx, String key,boolean value){
        SharedPreferences sharedPreferences=getSharedPreferences(ctx);
        sharedPreferences.edit().putBoolean(key,value).commit();
    }

    public static  Boolean getBoolean(Context ctx,String key,Boolean... defaultVavlue){
        SharedPreferences sharedPreferences=getSharedPreferences(ctx);
        Boolean dv=false;
        for(boolean v:defaultVavlue){
            dv = v;
            break;
        }
        return sharedPreferences.getBoolean(key,dv);
    }
    private  static  SharedPreferences getSharedPreferences(Context context){
        return context.getSharedPreferences(STORAGE_FILE_NAME,Context.MODE_PRIVATE);
    }
}
