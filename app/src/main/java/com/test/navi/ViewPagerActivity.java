package com.test.navi;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentContainer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.test.navi.tool.MyViewPageAdapter;

import java.util.ArrayList;

public class ViewPagerActivity extends FragmentActivity implements MyFragment.OnFragmentInteractionListener{
    public static final int count = 2;
    public ViewPager viewPager;
    public ArrayList<Fragment> mFragmentList;


    public Bundle bundle;
    public MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        // 初始化View
        initView();

    }

    public void initView(){

        if (findViewById(R.id.muti_fragment) != null){
            // 准备数据
            String frag1 = "这是第一个fragment";
            String frag2 = "这是第二个fragment";
            mFragmentList = new ArrayList<Fragment>();

            // 构造适配器

            mFragmentList.add(MyFragment.newInstance(frag1));
            mFragmentList.add(MyFragment.newInstance(frag2));

            MyViewPageAdapter myViewPageAdapter = new MyViewPageAdapter(getSupportFragmentManager(),mFragmentList);


            // 将Adapter 与 View 绑定
            viewPager = (ViewPager)findViewById(R.id.load_fragment);
            viewPager.setAdapter(myViewPageAdapter);
            viewPager.addOnPageChangeListener(new MyPageChangeListener());

            if (myViewPageAdapter.getCount() != 0){
                viewPager.setCurrentItem(0);
            }else {
                Toast.makeText(this, "没有获取到安装包信息", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void onFragmentInteraction(Uri uri){

        Log.e("dan", "fragment 添加到了 Activity");


    }

    public class MyPageChangeListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int i, float v, int i1) {


        }

        @Override
        public void onPageSelected(int i) {

            viewPager.setTag("");
            viewPager.setCurrentItem(i);
            Toast.makeText(ViewPagerActivity.this, "到了第"+ i + "个fragment", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }
}
