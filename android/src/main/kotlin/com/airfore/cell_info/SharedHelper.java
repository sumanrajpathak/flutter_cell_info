package com.airfore.cell_info;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedHelper {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void putString(Context context, String key, String Value) {
        sharedPreferences = context.getSharedPreferences("FlutterSharedPreferences", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("flutter."+key, Value);
        editor.commit();

    }

    public static String getString(Context contextGetKey, String key) {
        sharedPreferences = contextGetKey.getSharedPreferences("FlutterSharedPreferences", Context.MODE_PRIVATE);
        String Value = sharedPreferences.getString("flutter."+key, "");
        return Value;

    }

    public static boolean getBoolean(Context contextGetKey, String Key) {
        sharedPreferences = contextGetKey.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        boolean Value = sharedPreferences.getBoolean(Key, false);
        return Value;

    }

    public static int getInt(Context contextGetKey, String Key) {
        sharedPreferences = contextGetKey.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        int Value = sharedPreferences.getInt(Key, 0);
        return Value;

    }

    public static void putBoolean(Context context, String Key, boolean Value) {
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putBoolean(Key, Value);
        editor.commit();

    }


    public static void putInt(Context context, String Key, int Value) {
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(Key, Value);
        editor.commit();

    }

    public static void putIntApply(Context context, String Key, int Value) {
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putInt(Key, Value);
        editor.apply();

    }


    public static void clearSharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences("Cache", Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();

    }


}
