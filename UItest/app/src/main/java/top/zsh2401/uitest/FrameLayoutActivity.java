package top.zsh2401.uitest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrameLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);
        Button button_gotoPercentLayoutActivity = (Button)findViewById(R.id.button_gotoPercentLayout);
        button_gotoPercentLayoutActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PercentLayoutActivity.startAction(FrameLayoutActivity.this);
            }
        });
    }
    public static void startAction(Context context){
        Intent intent = new Intent(context,FrameLayoutActivity.class);
        context.startActivity(intent);
    }
}
