package com.jhonlee.lib.base;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jhonlee.lib.ioc.BindUtils;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getmResId(),container,false);
        initData();
        BindUtils.init(view,this);
        initView(view);
        initTitle(view);
        return view;
    }

    public abstract int getmResId();
    public abstract void initView(View view);
    public abstract void initData();
    public abstract void initTitle(View view);
    public void startActivity(Class clazz){
        Intent intent = new Intent(getActivity(),clazz);
        startActivity(intent);
    }
    public void startActivity(Class clazz,Bundle bundle){
        Intent intent = new Intent(getActivity(),clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
