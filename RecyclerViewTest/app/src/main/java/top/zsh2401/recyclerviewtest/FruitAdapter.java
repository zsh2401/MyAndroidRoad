package top.zsh2401.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by zsh2401 on 2017/6/3.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    /*这是一个用来构造水果数据的adapter构造器*/
    private List<Fruit> mFruitList;//定力水果列表
    static class ViewHolder extends RecyclerView.ViewHolder{
        /*定义viewHolde类,依我的理解,或许是个...容器?*/
        ImageView fruitImage;
        TextView fruitName;
        View fruitView;
        public ViewHolder(View view){
            /*构造器函数*/
            super(view);//交给父亲处理
            //定义数据
            fruitView = view;
            fruitImage = (ImageView)view.findViewById(R.id.fruit_image);
            fruitName = (TextView)view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> fruitList){
        /*构造器*/
        mFruitList = fruitList;//获取数据
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int ViewType){
        /*
        * 此方法用于创建ViewHolder实例,初始化每个item
        * 我的理解:    初始化每个容器
        * */
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_layout,parent,false);//动态加载水果选项布局

        final ViewHolder holder = new ViewHolder(view);//将holder设置为这个水果选项

        //为fruitView和其中的imageView设置点击事件
        holder.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),
                        "你点击了" +fruit.getName(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),
                        "你点击了图片 " +fruit.getName(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        /*                      ↑加载到的那个viewHolder   ↑位置
        * 当选项被滚动到屏幕内时就执行
        * 我的理解,当容器滚动到屏幕内,初始化一些东西
        * */
        Fruit fruit = mFruitList.get(position);//获取当前位置的水果实例
        holder.fruitImage.setImageResource(fruit.getImageId());//在holder里设置图片
        holder.fruitName.setText(fruit.getName());//和名字
    }
    @Override
    public int getItemCount(){
        //这函数就是返回一下总共有几个选项而已,无关紧要
        return mFruitList.size();
    }

}
