package me.yangtong.boringman;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.List;

import me.yangtong.boringman.database.TimeOperate;
import me.yangtong.boringman.model.TimeInfo;


public class MainActivity extends ActionBarActivity {

    protected Button insertButton;
    protected Button queryButton;
    protected Button deleteButton;


    TimeOperate timeOperate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeOperate = new TimeOperate(MainActivity.this);

        insertButton = (Button)findViewById(R.id.button_insert);
        queryButton = (Button)findViewById(R.id.button_query);
        deleteButton = (Button)findViewById(R.id.button_delete);

        insertButton.setOnClickListener(clickListener);
        queryButton.setOnClickListener(clickListener);
        deleteButton.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_insert:
                    TimeInfo timeInfo = new TimeInfo();
                    timeInfo.startTime = 1000000000;
                    timeInfo.endTime = 200000000;
                    timeInfo.appInfo = "com.changhong.appcontrol";
                    timeInfo.type = 1;
                    timeOperate.insertTimeInfo(timeInfo);
                    break;
                case R.id.button_query:
                    List<TimeInfo> timeInfos = timeOperate.getAllTimeInfo();
                    if(timeInfos!=null&&timeInfos.size()>0){
                        Log.i("yangtong","query result size >>"+timeInfos.size());
                        for(TimeInfo mTimeInfo:timeInfos){
                            Log.i("yangtong","   id"+mTimeInfo.id+
                                    "   startTime"+mTimeInfo.startTime+
                                    "   endTime"+mTimeInfo.endTime+
                                    "   appInfo"+mTimeInfo.appInfo+
                                    "   type"+mTimeInfo.type);
                        }
                    }else {
                        Log.e("yangtong", "query result is null");
                    }
                    break;
                case R.id.button_delete:
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
