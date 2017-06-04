package top.zsh2401.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zsh2401 on 2017/6/3.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {
    /*水果列表的构造器*/
    private int resId;//设置textview的ID
    public FruitAdapter(Context context, int textViewResId, List<Fruit> objects){
        super(context,textViewResId,objects);
        resId = textViewResId;//构造时获取子布局ID,什么是子布局?ListView里面的那些小的选项,懂了吧?
    }

    @NonNull
    @Override                                   //↓.这个是缓存
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        /*这个方法在listview的子项出现在屏幕时,都会执行,进行重写以显示图片*/
        //获取当前的Fruit实例
        Fruit fruit = getItem(position);
        View view;
        ViewHolder viewHolder;//缓存
        if (convertView == null){
            //如果缓存的view为Null
            //动态加载一个布局文件,resID为要加载的子布局,第二个是父布局
            view = LayoutInflater.from(getContext()).inflate(resId,parent,false);
            viewHolder = new ViewHolder();//viewholder用来进行缓存一些数据
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder);//将viewHolder存储在view中
        }else{
            //如果缓存的view不为null
            view = convertView;//提取出之前缓存的view
            viewHolder = (ViewHolder)view.getTag();//从view中获取viewholder
        }
        //设置水果图和水果名
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());
        //返回需要显示的View
        return view;
    }
    class ViewHolder{
        //缓存
        ImageView fruitImage;
        TextView fruitName;
    }
}
