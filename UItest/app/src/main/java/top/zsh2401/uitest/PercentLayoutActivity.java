package top.zsh2401.uitest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PercentLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
    public static void startAction(Context context){
        Intent intent = new Intent(context,PercentLayoutActivity.class);
        context.startActivity(intent);

    }
}
