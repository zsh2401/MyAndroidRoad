package top.zsh2401.f5calltools;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_about_item:
                Intent about_act = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(about_act);
                break;
            case R.id.menu_exit_item:
                finish();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listening();
    }
    private void listening(){
        TextView zsh = (TextView)findViewById(R.id.zsh);
        zsh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    Intent call_zsh = new Intent(Intent.ACTION_CALL, Uri.parse("tel:15911516469"));
                    startActivity(call_zsh);
                }catch (Exception e) {
                    Intent call_zsh = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:15911516469"));
                    startActivity(call_zsh);
                }
                //Toast.makeText(MainActivity.this, "呼叫张顺泓!", Toast.LENGTH_SHORT).show();
            }
        });
        TextView my = (TextView)findViewById(R.id.my);
        my.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    Intent call_my = new Intent(Intent.ACTION_CALL, Uri.parse("tel:15198831938"));
                    startActivity(call_my);
                }catch (Exception e){
                    Intent call_my = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:15198831938"));
                    startActivity(call_my);
                }
                //Toast.makeText(MainActivity.this,"呼叫马伊!",Toast.LENGTH_SHORT).show();
            }
        });
        TextView yh = (TextView)findViewById(R.id.yh);
        yh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent call_yh = new Intent(MainActivity.this,YhActivity.class);
                startActivity(call_yh);
            }
        });
        TextView ljy = (TextView)findViewById(R.id.ljy);
        ljy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent call_ljy = new Intent(MainActivity.this,LjyActivity.class);
                startActivity(call_ljy);
            }
        });
        TextView hxy = (TextView)findViewById(R.id.hxy);
        hxy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    Intent call_hxy = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18725157202"));
                    startActivity(call_hxy);
                }catch (Exception e){
                    Intent call_hxy = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18725157202"));
                    startActivity(call_hxy);
                }

                //Toast.makeText(MainActivity.this,"呼叫!",Toast.LENGTH_SHORT).show();
            }
        });
        TextView button_main_exit = (TextView)findViewById(R.id.main_exit);
        button_main_exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

    }
}
