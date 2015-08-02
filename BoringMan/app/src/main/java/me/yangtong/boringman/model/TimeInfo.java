package me.yangtong.boringman.model;

/**
 * Created by yangtong on 2015/7/2.
 */
public class TimeInfo {
    public static final String ID = "id";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";
    public static final String APP_INFO = "appInfo";
    public static final String TYPE = "type";

    public int id;
    public long startTime;
    public long endTime;
    public String appInfo;
    /**
     * 该时间类型，根据应用来决定.
     * 1.Boring,waste time
     * 2.Necessary,answer phone or send message
     * 3.Learn or something else meaningful
     */
    public int type;
}
