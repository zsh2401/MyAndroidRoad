package top.zsh2401.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int fragment_mark = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取按钮实例,设置按钮监听事件
        Button button_1 = (Button)findViewById(R.id.button_1);
        button_1.setOnClickListener(this);

        //放一个Fragment
        replaceFragment(R.id.right_layout,new RightFragment());

        //隐藏actionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onClick(View v) {
        /*点击事件*/
        switch (v.getId()){
            case R.id.button_1:
                if (fragment_mark ==1){
                    replaceFragment(R.id.right_layout,new AnotherFragment());
                    fragment_mark = 2;
                }else if(fragment_mark==2) {
                    replaceFragment(R.id.right_layout,new RightFragment());
                    fragment_mark = 1;
                }
                break;
            default:
                break;
        }
    }
    private void replaceFragment(int layoutId,Fragment fragment){
        /*
        * 此方法在右边布局放入传入的Fragment
        * */
        //获取Fragment管理器实例
        FragmentManager fragmentManager = getSupportFragmentManager();
        //创建一个事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //事务添加事情,用repla方法,传入要放的地方(容器的ID)和要放的东西(待添加的碎片实例)
        transaction.replace(layoutId,fragment);
        //提交事务
        transaction.commit();
    }
}
