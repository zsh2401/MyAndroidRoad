package top.zsh2401.recyclerviewtest;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Fruit> fruitList = new ArrayList<>();//定义列表
    private static Random random = new Random();
    String[] nameList = {
            "Watermelon",
            "Apple",
            "Over the Sky"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();//初始化水果表
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);//获取recy布局对象
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);//获取布局管理器
//        layoutManager.setOrientation(layoutManager.HORIZONTAL);//设置布局管理器为横向型
        StaggeredGridLayoutManager layoutManager =               //这是我第一次见到的布局管理器...666
                new StaggeredGridLayoutManager(3,//列
                        StaggeredGridLayoutManager.VERTICAL//横向
                        );
        recyclerView.setLayoutManager(layoutManager);//将recy设置布局管理器
        FruitAdapter adapter = new FruitAdapter(fruitList);//构造数据
        recyclerView.setAdapter(adapter);//设置数据
    }
    private void initFruits(){
        /*
        * 初始化水果列表
        * */
        for(int x = 0;x < 10;x++){
            for(String name:nameList){
                Fruit fruit = new Fruit(getRandomString(getRandomInt(),name),R.mipmap.ic_launcher);
                fruitList.add(fruit);
            }
        }

    }
    public static String getRandomString(int length, @Nullable String name) {
        /*此方法用于获取随机字符串
        * 参数:   length  可决定得到的随机字符串的长度
        * 参数:   name        如果传入非null的值,则会返回由lenght个name组成的字符串
        *                       否则生成随机的a-z,0-9组成的字符串
        * */
        String result;
        if(name == null){
            String base = "abcdefghijklmnopqrstuvwxyz0123456789";
            StringBuffer sb = new StringBuffer();//String容器
            for (int i = 0; i < length; i++) {//不断获取随机字符直到数量达到限制
                int number = random.nextInt(base.length());
                sb.append(base.charAt(number));
            }
            result = sb.toString();//返回String容器中的完整字符串
        }else{
            for(int i = 0;i<length;i++){
                name += name;
            }
            result = name;
        }
        return result;

    }
    public static int getRandomInt(){
        //获取随机数字
        int max = 5;
        return random.nextInt(max);
    }
}
