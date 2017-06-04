package top.zsh2401.activitytest;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends BaseActivity {
    public final String TAG = "SecondActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"taks id is " + getTaskId());
        setContentView(R.layout.second_act);
        setButtonsClick();
        Intent to_there_intent = getIntent();//获取调用这个activity的意图
        //String data = to_there_intent.getStringExtra("some_data");//从意图当中通过数据名获取具体数据
        //String name = to_there_intent.getStringExtra("extra_name");
        Bundle bundle = to_there_intent.getBundleExtra("bundle");//从意图当中获取传入的bundle
        String bundle_test_message = bundle.getString("data1");//从传入的bundle调出需要的数据
        Log.d(TAG,bundle_test_message);//展示从上个activity传入的bundle中的一个数据
    }
    public static void actionStart(Context context,String data1,String data2){
        /*将启动方法写在activity中,这样读代码就方便了许许多多*/
        Intent sa = new Intent(context,SecondActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("data1",data1);
        bundle.putString("data2",data2);
        sa.putExtra("bundle",bundle);
        context.startActivity(sa);
    }
    protected void setButtonsClick(){
        /*设置button的click事件*/
        Button button_ys = (Button) findViewById(R.id.button_ys);
        button_ys.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent_1 = new Intent("top.zsh2401.activitytest.ABOUT_ACTIVITY");
                        //intent_1.addCategory("top.zsh2401.activity.MY_CATEGORY");
                        startActivity(intent_1);
                        Log.d("SecondActivity","onClick execute");
                    }
                }
        );
        Button button_open_with_browser = (Button)findViewById(R.id.button_open_with_browser);
        button_open_with_browser.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        /*隐式intent启动百度网页*/
                        Intent open_baidu_with_browser = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.baidu.com"));
                        startActivity(open_baidu_with_browser);
                    }
                }
        );
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(//当点击返回按钮时,向上个activity传回数据
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent result_intent = new Intent();//创建一个intent作为回传数据
                        result_intent.putExtra("result","Ok! 成功返回数据!");
                        setResult(RESULT_OK,result_intent);//将数据处理结果和具体数据传回
                        finish();
                    }
                }
        );
        Button button_call_to_10086 = (Button)findViewById(R.id.button_call_to_10086);
        button_call_to_10086.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                /*实例化一个intent对象,动作是DIAL,具体资源是Uri.parse("tel:10086")
                * 这将会跳转到电话界面给10086打电话
                * */
                Intent call_to_10086 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:10086"));
                startActivity(call_to_10086);
            }
        });
        Button buttonOpenBlog = (Button)findViewById(R.id.button_blog_with_webview);
        buttonOpenBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToBlogWebViewActivity = new Intent(SecondActivity.this,BlogWebViewActivity.class);
                startActivity(goToBlogWebViewActivity);
            }
        });
        /*这个按钮用于启动SingleInstanceActivity,这个活动顾名思义,就是SingleInstanceActivity启动模式的*/
        Button buttonStartSingleInstanceActivity = (Button)findViewById(R.id.button_start_single_instance_activity);
        buttonStartSingleInstanceActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startSingleInstanceActivity = new Intent(SecondActivity.this,SingleInstanceActivity.class);
                startActivity(startSingleInstanceActivity);
            }
        });
        /*这个按钮用于关闭所有activity*/
        Button buttonFinishAll = (Button)findViewById(R.id.button_finish_all);
        buttonFinishAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityManager.finishAll();
                Process.killProcess(Process.myPid());//这段代码会杀死所有进程,让程序彻底玩完
            }
        });
    }
}
