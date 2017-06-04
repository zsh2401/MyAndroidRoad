package top.zsh2401.dreamleaner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import static android.util.Log.*;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在这里测试了log.d这玩意儿
        Log.v("MainActivity","onCreate execute");

    }
}
