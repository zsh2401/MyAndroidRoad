package top.zsh2401.uitest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by zsh2401 on 2017/6/2.
 */

public class TitleLayout extends LinearLayout {
    public TitleLayout(Context context, AttributeSet attributeSetrs){
        super(context,attributeSetrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button back = (Button)findViewById(R.id.title_back);
        Button about = (Button)findViewById(R.id.title_about);
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
        about.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutActivity.startAction(((Activity)getContext()));
            }
        });
    }
}
