package com.test.navi.tool;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentList;

    /**
     * 申请了一个Fragment 的数组对象，用于保存滑动的Fragment对象，需要在 Fragment 的创造函数中初始化
     * @param fragmentManager
     * @param fragmentList
     */
    public MyViewPageAdapter(FragmentManager fragmentManager, ArrayList<Fragment> fragmentList){
        super(fragmentManager);
        this.mFragmentList = fragmentList;
    }
    @Override
    public int getCount() {
        // 展示页面的个数
        return mFragmentList.size();
    }

    @Override
    public Fragment getItem(int i) {
        return mFragmentList.get(i);
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        //这种写法返回的是false, 因为fragment 不是 view 类型
        // return view == object;
        return ((Fragment)object).getView() == view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }


}
