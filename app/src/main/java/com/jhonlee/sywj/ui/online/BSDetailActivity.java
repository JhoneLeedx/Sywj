package com.jhonlee.sywj.ui.online;

import com.jhonlee.lib.base.BaseActivity;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.ui.ToolBar;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/13
 * @Version 1.0
 * @Description
 */
public class BSDetailActivity extends BaseActivity{
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_bs_detail);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initTitle() {
        String title = getIntent().getStringExtra("title");
        new ToolBar.Builder(this)
                .setTitle(title)
                .builder();
    }
}
