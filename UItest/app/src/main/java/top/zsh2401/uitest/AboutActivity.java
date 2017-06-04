package top.zsh2401.uitest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }
    }
    public static void startAction(Context context){
        Log.d("fuck","startAction");
        Intent intent = new Intent(context,AboutActivity.class);
        context.startActivity(intent);
    }
    public static void startAction(){
        //TODO
    }
}
