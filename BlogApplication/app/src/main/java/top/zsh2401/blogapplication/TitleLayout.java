package top.zsh2401.blogapplication;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by zsh2401 on 2017/6/2.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout,this);
        Button button_about = (Button)findViewById(R.id.button_about);
        button_about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.startAction((Activity)getContext());
            }
        });
    }
}
