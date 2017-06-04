package top.zsh2401.f5calltools;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.Button;

public class YhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yh);
        listening();
    }
    private void listening(){
        Button button_call_yh_zuoji = (Button) findViewById(R.id.button_call_yh_zuoji);
        button_call_yh_zuoji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent call_yh_zuoji = new Intent(Intent.ACTION_CALL,Uri.parse("tel:68751060"));
                    startActivity(call_yh_zuoji);
                }catch (Exception e){
                    Intent call_yh_zuoji = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:68751060"));
                    startActivity(call_yh_zuoji);
                }

            }
        });
        Button button_call_yh_phone = (Button) findViewById(R.id.button_call_yh_phone);
        button_call_yh_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent call_ljy_mi4 = new Intent(Intent.ACTION_CALL,Uri.parse("tel:15912424902"));
                    startActivity(call_ljy_mi4);
                }catch (Exception e){
                    Intent call_yh_phone = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:15288127227"));
                    startActivity(call_yh_phone);
                }

            }
        });
        Button back = (Button)findViewById(R.id.button_activity_yh_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
