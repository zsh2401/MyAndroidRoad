package top.zsh2401.uitest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.provider.Settings;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar_0;
    private ProgressBar progressBar_1;
    private Button button_1;
    private Button button_2;
    private Button button_progress_0;
    private Button button_progress_1;
    private Button button_alert_dialog;
    private Button button_progress_dialog;
    private Button button_gotoRelativeLayoutActivity;
    private AlertDialog.Builder dialog;
    private ProgressDialog progressDialog;
    private int pic_type = 0;
    private final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        fuzhi();
        setListener();

    }
    protected void fuzhi(){
        editText = (EditText)findViewById(R.id.edit_text_one);
        imageView = (ImageView)findViewById(R.id.image_view);
        progressBar_0 = (ProgressBar)findViewById(R.id.progress_bar_0);
        progressBar_1 = (ProgressBar)findViewById(R.id.progress_bar_1);
        button_1 = (Button)findViewById(R.id.button_0);
        button_2 = (Button)findViewById(R.id.button_change_pic);
        button_progress_0 = (Button)findViewById(R.id.button_progress_0);
        button_progress_1 = (Button)findViewById(R.id.button_progress_1);
        button_alert_dialog = (Button)findViewById(R.id.button_alert_dialog);
        button_progress_dialog =(Button)findViewById(R.id.button_progress_dialog);
        button_gotoRelativeLayoutActivity = (Button)findViewById(R.id.button_gotoRelativeLayout);
        dialog = new AlertDialog.Builder(MainActivity.this);
        progressDialog = new ProgressDialog(MainActivity.this);
    }
    protected void setListener(){
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_progress_0.setOnClickListener(this);
        button_progress_1.setOnClickListener(this);
        button_alert_dialog.setOnClickListener(this);
        button_progress_dialog.setOnClickListener(this);
        button_gotoRelativeLayoutActivity.setOnClickListener(this);
    }

    public void onClick(View v) {
        //System.out.println(v.getId());
        switch (v.getId()){
            case R.id.button_0:
                String text = editText.getText().toString();
                    Toast.makeText(MainActivity.this,
                            "输入框内容-->    " + text,
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_change_pic:
                //System.out.println(R.id.button_change_pic);
                Log.d(TAG,"button_change_pic被按下了");
                if (pic_type == 0) {
                    imageView.setImageResource(R.mipmap.ic_launcher_round);
                    pic_type = 1;
                }else if(pic_type == 1){
                    imageView.setImageResource(R.mipmap.ic_launcher);
                    pic_type = 0;
                }
                break;
            case R.id.button_progress_0:
                //System.out.println(R.id.button_progress_0);
                Log.d(TAG,"button_progress_0被按下了");
                if (progressBar_0.getVisibility() == View.GONE){
                    progressBar_0.setVisibility(View.VISIBLE);
                }else{
                    progressBar_0.setVisibility(View.GONE);
                }
                break;
            case R.id.button_progress_1:
                Log.d(TAG,"button_progress_1被按下了");
                if (progressBar_1.getProgress() < progressBar_1.getMax()) {
                    progressBar_1.setProgress(progressBar_1.getProgress() + 10);
                }else{
                    progressBar_1.setProgress(0);
                }
                break;
            case R.id.button_alert_dialog:
                Log.d(TAG,"打开dialog的按钮被按下了");
                dialog.setTitle("标题:这是一个Alert dialog!");
                dialog.setMessage("内容:一些重要的信息");
                dialog.setCancelable(false);//无法用返回键退出这个程序
                /*重写这个dialog的触摸事件*/
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "点了OK",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,
                                "点了cancel",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();//展示这个dialog
                break;
            case R.id.button_progress_dialog:
                progressDialog.setTitle("这是一个progressDialog");
                progressDialog.setMessage("正在进行一些操作....");
                progressDialog.setCancelable(true);
                progressDialog.show();
                //progressDialog.dismiss();这个方法将会关闭显示ProgressDialog
                break;
            case R.id.button_gotoRelativeLayout:
                RelativeLayoutActivity.startAction(MainActivity.this);
            default:
                break;
        }

    }


}
