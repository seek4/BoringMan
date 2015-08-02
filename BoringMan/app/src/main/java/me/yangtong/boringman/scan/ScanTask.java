package me.yangtong.boringman.scan;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;
import java.util.TimerTask;

import me.yangtong.boringman.debug.Common;

/**
 * Created by yangtong on 2015/7/15.
 */
public class ScanTask extends TimerTask {
    private NewDataCallBack callBack;

    public ScanTask(NewDataCallBack callBack,Context context) {
        this.callBack = callBack;
        this.activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);

    }

    private ActivityManager activityManager;
    private List<ActivityManager.RunningAppProcessInfo> runnings;
    @Override
    public void run() {
        runnings = activityManager.getRunningAppProcesses();
        for(ActivityManager.RunningAppProcessInfo info:runnings){
            Common.LOG_I(info.processName);
        }
        callBack.onDataGotton("");
    }
}
