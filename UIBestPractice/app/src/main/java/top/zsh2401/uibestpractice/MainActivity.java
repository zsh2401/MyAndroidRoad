package top.zsh2401.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();
    private EditText inputText;
    private Button send;
    private RecyclerView msgRecy;
    private MsgAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsg();//初始化信息
        //实例化各种对象
        inputText = (EditText)findViewById(R.id.edit_text);
        send = (Button)findViewById(R.id.button_send);
        msgRecy = (RecyclerView)findViewById(R.id.recy_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new MsgAdapter(msgList);

        //设置
        msgRecy.setLayoutManager(layoutManager);//RecyclerView的布局管理器进行设置
        msgRecy.setAdapter(adapter);//传入构造器构造的数据
        send.setOnClickListener(new View.OnClickListener() {//设置发送按钮的点击事件
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){//如果输入的不是空的
                    Msg msg = new Msg(content,Msg.TYPE_SENT);//创建信息对象
                    msgList.add(msg);//添加信息
                    adapter.notifyItemInserted(msgList.size()-1);//通知列表有新的对象传入,麻烦添加一下
                    msgRecy.scrollToPosition(msgList.size()-1);//定位到最后一行
                    inputText.setText("");//清空输入框
                }
            }
        });
    }
    private void initMsg(){
        /*初始化信息表*/
        Msg msg1 = new Msg("Hello",Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("Hello 2",Msg.TYPE_SENT);
        Msg msg3 = new Msg("Hello 3",Msg.TYPE_RECEIVED);
        msgList.add(msg1);
        msgList.add(msg2);
        msgList.add(msg3);

    }
}
