package top.zsh2401.f5calltools;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FlashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shanping);
        TextView version = (TextView)findViewById(R.id.flash_screen_version);
        version.setText("wow");
// 闪屏的核心代码
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(FlashScreen.this, MainActivity.class); //从启动动画ui跳转到主ui
                startActivity(intent);
                FlashScreen.this.finish(); // 结束启动动画界面
            }
        }, 500);//启动动画持续3秒钟
    }
}

