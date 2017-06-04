package top.zsh2401.activitytest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BlogWebViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_web_view);
        WebView bwv = (WebView)findViewById(R.id.blog_web_view);
        bwv.getSettings().setJavaScriptEnabled(true);
        bwv.setWebViewClient(new WebViewClient());
        bwv.loadUrl("http://zsh2401.top");
    }
}
