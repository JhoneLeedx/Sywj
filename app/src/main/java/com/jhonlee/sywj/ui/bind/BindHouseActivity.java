package com.jhonlee.sywj.ui.bind;


import android.view.View;

import com.jhonlee.lib.base.BaseActivity;
import com.jhonlee.lib.ioc.Click;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.mvp.ISuccessView;
import com.jhonlee.sywj.pojo.Result;
import com.jhonlee.sywj.ui.ToolBar;

import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class BindHouseActivity extends BaseActivity implements ISuccessView{

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_bind_house);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initTitle() {
        new ToolBar.Builder(this).setTitle("房屋绑定").builder();
    }

    @Click({R.id.linear_city, R.id.linear_dy, R.id.linear_ld, R.id.linear_xq, R.id.linear_house})
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.linear_city:
                break;
            case R.id.linear_dy:
                break;
            case R.id.linear_ld:
                break;
            case R.id.linear_xq:
                break;
            case R.id.linear_house:
                break;
        }
    }

    @Override
    public void onSuccess(List<Result> results) {

    }
}
