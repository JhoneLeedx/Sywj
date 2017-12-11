package com.jhonlee.sywj.ui.main.fragment;

import android.view.View;
import android.view.ViewGroup;

import com.jhonlee.lib.base.BaseFragment;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.ui.ToolBar;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
public class LifeFragment extends BaseFragment {

    @Override
    public int getmResId() {
        return R.layout.fragment_life;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initTitle(View view) {
        new ToolBar.Builder(getActivity(),(ViewGroup)view)
                .setVisibility(true)
                .setTitle("搜索商品")
                .builder();
    }
}
