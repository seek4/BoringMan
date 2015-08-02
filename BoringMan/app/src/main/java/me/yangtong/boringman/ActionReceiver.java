package me.yangtong.boringman;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import me.yangtong.boringman.debug.Common;

/**
 * Created by yangtong on 2015/7/15.
 */
public class ActionReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(Intent.ACTION_BOOT_COMPLETED)){
            Common.LOG_I("onReceive ACTION_BOOT_COMPLETED");
            Intent scanService = new Intent();
            scanService.setAction("com.yangtong.boringman.actionscan");
            context.startService(scanService);
        }else if (action.equals(Intent.ACTION_SCREEN_ON)){
            Common.LOG_I("onReceive ACTION_SCREEN_ON");
        }else if(action.equals(Intent.ACTION_SCREEN_OFF)){
            Common.LOG_I("onReceive ACTION_SCREEN_OFF");
        }
    }
}
