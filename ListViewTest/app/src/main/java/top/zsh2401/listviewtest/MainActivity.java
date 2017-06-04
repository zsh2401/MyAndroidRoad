package top.zsh2401.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //定义列表
    private String[] data = {"Apple","Banana","Organe","Watermelon",
            "Pear","Grape","Pineapple","Strawberry","Cherry","Mango",
            "Apple","Banana","Organe","Watermelon",
            "Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};
    //定义一个水果列表
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化水果列表
        initFruits();
        //用自己写的FruitAdapter来生成一个带图的FruitAdapter
        FruitAdapter adapter = new FruitAdapter(
                MainActivity.this,//上下文
                R.layout.layout,//每个单独的水果显示布局
                fruitList);//水果列表
        //将FruitAdapter传给listview进行显示
        ListView lv = (ListView)findViewById(R.id.list_item_1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //设置这个listview的监听器
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,
                        fruit.getName(),
                        20).show();

            }
        });
    }
    private void initFruits(){
        //初始化水果表,将data中的数据依次加入进去
        for(String name:data){
            Fruit x = new Fruit(name,R.mipmap.ic_launcher);
            fruitList.add(x);
        }

    }
}
