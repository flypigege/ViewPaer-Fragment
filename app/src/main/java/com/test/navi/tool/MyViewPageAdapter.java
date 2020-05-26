package com.test.navi.tool;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentList;

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
        return  view == object;
    }

//    @NonNull
//    @Override
//    public Fragment instantiateItem(@NonNull ViewGroup container, int position) {
//        Fragment fragment = mFragmentList.get(position);
//        container.addView((View)fragment);
//        return fragment;
//    }

//    @Override
//    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//        super.destroyItem(container, position, object);
//    }


}
