package top.zsh2401.uitest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class RelativeLayoutActivity extends AppCompatActivity{
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);
        Button button_gotoFrameLayout = (Button)findViewById(R.id.button_gotoFrameLayout);
        button_gotoFrameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FrameLayoutActivity.startAction(RelativeLayoutActivity.this);
            }
        });
    }
    public static void startAction(Context context){
        Intent intent = new Intent(context,RelativeLayoutActivity.class);
        context.startActivity(intent);
    }

}
