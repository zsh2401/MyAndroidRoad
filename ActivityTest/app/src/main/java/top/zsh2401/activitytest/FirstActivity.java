package top.zsh2401.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {
    public static final String TAG="FirstActivity";
    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*当一个activity被销毁时,将会调用上一个活动的onActivityResult方法
        * 此时,可以重写这个方法来进行一些处理,比如将数据存着或者用Toast显示出来
        * */
        switch (requestCode){//requestCode是我们一开始定义的返回数据的标识,用来标记是谁返回的
            case 2://如果是2的数据(也就是secondactivity的)
                if (resultCode == RESULT_OK){//如果返回数据正常
                    Toast.makeText(FirstActivity.this,//将数据显示出来
                            data.getStringExtra("result"),
                            Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){//当菜单按钮被选中时...
        //重写了当选中菜单时的方法
        switch (item.getItemId()){//用switch判断选中的菜单按钮ID
            case R.id.add_item://如果选中菜单按钮ID与R.id.add_item相同,那么进行如下操作
                Toast.makeText(this,"WTF",Toast.LENGTH_SHORT).show();//显示一个Toast
                break;
            case R.id.remove_item://选中的菜单按钮是add_item时,则进行如下操作
                Toast.makeText(this,"Nothing",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_item://选中的菜单按钮是about时,则进行如下操作
                Intent intent_x = new Intent("top.zsh2401.activitytest.ACTION_START");
                intent_x.addCategory("top.zsh2401.activity.MY_CATEGORY");
                startActivity(intent_x);
                break;
            case R.id.donate_item://选中的菜单按钮是donate时,则进行如下操作
                /*指定intent的action是Intent.ACTION_VIEW*\
                 用intent的setData方法,传入一个Uri对象,这个Uri对象是由百度网址解析的
                 运行这个activity 将向系统请求用浏览器打开这个网址 */
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
                break;

            default:

        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    protected void setButtonsClick(){
        Button button_1 = /*返回的是view对象,转换为button对象*/(Button) findViewById(R.id.button_1);//获取按钮实例
        button_1.setOnClickListener(//注册一个监听器
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){

                    /*Toast.makeText(//make一个toast的对象
                            FirstActivity.this,//传入context对象,也就是上下文
                            "Exit",//显示的文字
                            Toast.LENGTH_LONG//显示的时间,也可是LENGTH_SHORT
                    ).show();//将这个toast进行显示
                    finish();//结束当前activity
                    */

                    /*关于Activity的跳转*/
                        String data = "My name is ";
                        String name = "zsh2401";
                        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);//创建一个intent

                    /*在意图中存入数据供被调用的activity使用*/
                        //intent.putExtra("some_data",data);//在意图当中,放入数据 (数据名,具体数据)
                        //Bundle bundle = new Bundle();
                        //intent.putExtra("bundle",bundle);
                        //startActivity(intent);//前往这个intent代表的activity
                    /*这个函数启动activity可以获取被启动的activity返回的数据*/
                        //startActivityForResult(intent,2);//第二个参数,也就是用来识别返回数据的标识
                        SecondActivity.actionStart(FirstActivity.this,"bundle_test1","bundle_test2");
                    }
                }
        );
        Button button_dialog = (Button)findViewById(R.id.button_dialog);
        button_dialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startDialog = new Intent(FirstActivity.this,DialogActivity.class);
                startActivity(startDialog);
            }
        });
        Button button_create_firstactivity = (Button)findViewById(R.id.button_create_firstactivity);
        button_create_firstactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        /*活动在被回收前,将会调用这个方法,
        因此,我们可在其中存入一些本activity的数据,防止回收带来的数据丢失*/
        super.onSaveInstanceState(outState, outPersistentState);
        String recoveryMessage = "好了,本activity被回收前,存入了这段数据,并在重新创建时显示了这段数据";
        outState.putString("recoveryMessage",recoveryMessage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"taks id is " + getTaskId());
        if (savedInstanceState != null){//当activity重建时传入的数据不是空,说明这个activity被重建了
            String recoveryMessage = savedInstanceState.getString("recoveryMessage");//将重建传入的数据进行操作
            Log.d(TAG,recoveryMessage);//显示日志
        }
        Log.d(TAG,"onCreate");//显示activity被创建
        setContentView(R.layout.first_act);//让这个activity显示first_act的内容
        setButtonsClick();
    }

    /*显示该activity的各种状态*/
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"taks id is " + getTaskId());
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestory");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
