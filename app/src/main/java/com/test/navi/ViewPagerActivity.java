package com.test.navi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.test.navi.tool.MyViewPageAdapter;

import java.util.ArrayList;

public class ViewPagerActivity extends FragmentActivity {
    public static final int count = 2;
    public ViewPager viewPager;
    public ArrayList<Fragment> mFragmentList;

    public ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        // 初始化View
        initView();

    }

    public void initView(){
        // 准备数据
        String frag1 = "这是第一个fragment";
        String frag2 = "这是第二个fragment";
        dataList = new ArrayList<>();
        dataList.add(frag1);
        dataList.add(frag2);


        // 准备适配器
        viewPager = (ViewPager)findViewById(R.id.load_fragment);
        int i;
        for (i = 0; i < count; i++){
            mFragmentList.add(new MyFragment());
        }

        MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getSupportFragmentManager(),mFragmentList);
        // 将Adapter 与 View 绑定
        viewPager.setAdapter(myViewPageAdapter);

    }
}
