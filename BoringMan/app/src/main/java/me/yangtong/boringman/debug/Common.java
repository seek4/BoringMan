package me.yangtong.boringman.debug;

import android.util.Log;

/**
 * Created by yangtong on 2015/7/15.
 */
public class Common {
    public static final String LOG_TAG = "yangtong";

    public static void LOG_I(String log){
        Log.i(LOG_TAG,log);
    }

    public static void LOG_D(String log){
        Log.d(LOG_TAG, log);
    }

    public static void LOG_E(String log){
        Log.e(LOG_TAG,log);
    }

}
