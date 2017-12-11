package com.jhonlee.sywj.ui.main.adapter;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/8
 * @Version 1.0
 * @Description
 */
public class ViewPagerAdapter extends PagerAdapter {


    private List<View> pageViews = new ArrayList<View>();


    public ViewPagerAdapter(List<View> pageViews) {
        this.pageViews = pageViews;
    }

    @Override
    public int getCount() {
        return pageViews.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public void destroyItem(ViewGroup arg0, int arg1, Object arg2) {
        arg0.removeView((View) arg2);
    }

    @Override
    public Object instantiateItem(ViewGroup arg0, int arg1) {
       ViewGroup viewGroup = (ViewGroup) pageViews.get(arg1).getParent();
        if (viewGroup!=null){
            viewGroup.removeView(pageViews.get(arg1));
        }
        arg0.addView(pageViews.get(arg1));
        return pageViews.get(arg1);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }



}
