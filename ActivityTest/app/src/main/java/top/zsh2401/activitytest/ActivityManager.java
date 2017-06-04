package top.zsh2401.activitytest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zsh2401 on 2017/6/1.
 */

public class ActivityManager {
    public static List<Activity> acts = new ArrayList<>();
    public static void addActivity(Activity activity){
        acts.add(activity);
    }
    public static void removeActivity(Activity activity){
        acts.remove(activity);
    }
    public static void finishAll(){
        for(Activity activity : acts){
            activity.finish();
        }
        acts.clear();
    }
}
