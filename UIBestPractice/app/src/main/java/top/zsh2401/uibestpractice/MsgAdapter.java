package top.zsh2401.uibestpractice;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zsh2401 on 2017/6/4.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
    //Msg数据的适配器      继承自   RecyclerView的构造器,泛型为这里定义的ViewHolder

    private List<Msg> msgList;//定义信息列表
    static class ViewHolder extends RecyclerView.ViewHolder{
        /*内部类   ViewHolder容器 继承自 RecyclerView的ViewHoler容器*/
        //定义一堆数据
        LinearLayout leftlayout;
        LinearLayout rightlayout;
        TextView leftmsg;
        TextView rightmsg;
        public ViewHolder(View view){
            /*构造方法*/
            super(view);//让父亲进行主要操作
            //我们在这把布局创建对象
            leftlayout = (LinearLayout)view.findViewById(R.id.left_layout);
            rightlayout = (LinearLayout)view.findViewById(R.id.right_layout);
            leftmsg = (TextView) view.findViewById(R.id.left_msg);
            rightmsg = (TextView) view.findViewById(R.id.right_msg);
        }
    }
    public MsgAdapter(List<Msg> msgList){
        this.msgList = msgList;//构造器
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType){
        /*                                  父布局         布局的类型
        * 初始化每个ViewHolder容器
        * */
        //动态加载布局
        //                                   ↓上下文
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.msg_item,//要动态加载的子布局
                        parent,//父布局
                        false);//表示只让我们在父布局中声明的Layout属性生效,但不会为这个View添加父布局
                                //因为一旦View有了父布局,它就不能再添加到ListView中了
        final ViewHolder holder = new ViewHolder(view);//实例化ViewHolder

        //设置各自的点击事件
        holder.rightmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(),
                        holder.rightmsg.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.leftmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parent.getContext(),
                        holder.leftmsg.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
        return holder;//返回ViewHolder布局与数据容器
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        /*                      需要加载ViewHolder    所在的位置
        * 当滚动到要显示的ViewHolder数据容器时,将执行此方法
        * 此方法的目的在于,加载需要被显示的ViewHolder容器
        * */

        Msg msg = msgList.get(position);//根据所在位置提取相应的信息
        if (msg.getType() == msg.TYPE_RECEIVED){//如果这个信息,是接收的
            holder.leftlayout.setVisibility(View.VISIBLE);//显示左布局
            holder.rightlayout.setVisibility(View.GONE);//隐藏右布局
            holder.leftmsg.setText(msg.getContent());//将这个holder设置文字
        }else if(msg.getType() == msg.TYPE_SENT){//否则如果是发送的
            holder.rightlayout.setVisibility(View.VISIBLE);//隐藏左边的聊天栏
            holder.leftlayout.setVisibility(View.GONE);//显示右边的
            holder.rightmsg.setText(msg.getContent());//设置文字
        }
    }
    @Override
    public int getItemCount(){
        /*无关紧要*/
        return msgList.size();
    }
}
