package top.zsh2401.blogapplication;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private ProgressDialog dialog;
    private final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAnything();//设置所有东西
        webView.loadUrl(this.getString(R.string.url));//开始加载网页
    }
    protected void setRandomString(){
        int number = new Random().nextInt(10) + 1;
        switch (number){
            case 1:
                dialog.setMessage(this.getString(R.string.loading_message_1));
                break;
            case 2: case 8: case 9:
                dialog.setMessage(this.getString(R.string.loading_message_2));
                break;
            case 3: case 4:case 5:
                dialog.setMessage(this.getString(R.string.loading_message_3));
                break;
            case 6: case 7:
                dialog.setMessage(this.getString(R.string.loading_message_4));
                break;
            default:
                dialog.setMessage(this.getString(R.string.loading_message_0));
                break;
        }
    }
    protected void setAnything(){
        hideActionBar();//隐藏标题栏..
        setDialog();//设置加载提示
        setWebView();//设置webview
        overrideWebView();//重写webview加载时的代码,以显示加载提示

    }
    protected void setWebView(){
        //设置webview
        webView = (WebView)findViewById(R.id.web_view);
        //启用JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
    }
    protected void setDialog(){
        //设置加载提示
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle(this.getString(R.string.loading_title));//设置标题
        dialog.setMessage(this.getString(R.string.loading_message_0));//设置内容
        dialog.setCancelable(true);
    }
    protected void hideActionBar(){
        //隐藏actionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }
    protected void overrideWebView(){
        /*重写WebView在加载时的逻辑
        * 加载开始时,显示加载框
        * 加载结束后,关闭加载框
        * */
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                //打开时显示加载框
                setRandomString();
                dialog.show();
                Log.d(TAG,"Loding...");
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //加载完成关闭加载框
                dialog.dismiss();
                Log.d(TAG,"Lode Finish");
            }
        });
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /*重写当按下返回键时的代码,如果可以返回,那么就返回*/
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
