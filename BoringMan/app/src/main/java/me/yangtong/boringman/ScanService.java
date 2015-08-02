package me.yangtong.boringman;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.Timer;
import java.util.TimerTask;

import me.yangtong.boringman.scan.NewDataCallBack;
import me.yangtong.boringman.scan.ScanTask;

public class ScanService extends Service implements NewDataCallBack{
    public ScanService() {
    }

    private Timer timer;
    private ScanTask scanTask;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        timer = new Timer();
        scanTask = new ScanTask(this,ScanService.this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
