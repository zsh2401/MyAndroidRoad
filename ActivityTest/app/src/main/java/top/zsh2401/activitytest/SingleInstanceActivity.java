package top.zsh2401.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SingleInstanceActivity extends BaseActivity {
    public final String TAG="SingleInstanceActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"taks id is " + getTaskId());
        setContentView(R.layout.activity_single_instance);
    }
}
