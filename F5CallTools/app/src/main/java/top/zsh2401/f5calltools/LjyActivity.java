package top.zsh2401.f5calltools;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LjyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ljy);
        Button button_call_ljy_rm = (Button)findViewById(R.id.button_call_ljy_rm);
        button_call_ljy_rm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent call_ljy_rm_phone = new Intent(Intent.ACTION_CALL, Uri.parse("tel:15288293184"));
                    startActivity(call_ljy_rm_phone);
                }catch (Exception e){
                    Intent call_ljy_rm_phone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:15288293184"));
                    startActivity(call_ljy_rm_phone);
                }

            }
        });
        Button button_call_ljy_mi4 = (Button) findViewById(R.id.button_call_ljy_mi4);
        button_call_ljy_mi4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent call_ljy_mi4 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:15912424902"));
                    startActivity(call_ljy_mi4);
                }catch (Exception e){
                    Intent call_ljy_mi4 = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:15912424902"));
                    startActivity(call_ljy_mi4);
                }

            }
        });
        Button back = (Button)findViewById(R.id.button_activity_ljy_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
