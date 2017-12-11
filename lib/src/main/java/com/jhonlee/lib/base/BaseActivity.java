package com.jhonlee.lib.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jhonlee.lib.ioc.BindUtils;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        BindUtils.init(this);
        initData();
        initView();
        initTitle();

    }

    public abstract void setContentView();
    public abstract void initView();
    public abstract void initData();
    public abstract void initTitle();
    public void startActivity(Class clazz){
        Intent intent = new Intent(this,clazz);
        startActivity(intent);
    }
    public void startActivity(Class clazz,Bundle bundle){
        Intent intent = new Intent(this,clazz);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
