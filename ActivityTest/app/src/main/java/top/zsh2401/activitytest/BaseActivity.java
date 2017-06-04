package top.zsh2401.activitytest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by zsh2401 on 2017/6/1.
 */

public class BaseActivity extends AppCompatActivity {
    /*此类是项目中所有类的父类,也就是说,所有类在执行时都会执行这个类的代码*/
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d("There is ",getClass().getSimpleName());
        ActivityManager.addActivity(this);

    }
    protected void onDestroy(){
        super.onDestroy();
        ActivityManager.removeActivity(this);
    }
}
