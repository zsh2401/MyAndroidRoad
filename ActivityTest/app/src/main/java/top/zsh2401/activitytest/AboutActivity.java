package top.zsh2401.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AboutActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.about_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.contact_me_item:
                Intent phone_request = new Intent(Intent.ACTION_DIAL);//创建一个意图,动作为拨号
                phone_request.setData(Uri.parse("tel:15911516469"));//设置拨号的数据为Uri解析的数据
                startActivity(phone_request);//执行这个活动意图
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
    }
}
