package com.jhonlee.sywj.ui.online;

import android.view.View;
import android.view.ViewGroup;

import com.jhonlee.lib.base.BaseActivity;
import com.jhonlee.lib.ioc.Click;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.ui.ToolBar;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class ReportActivity extends BaseActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_report);
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initTitle() {
        new ToolBar.Builder(this)
                .setTitle("在线报事")
                .setRightText("报事历史")
                .setRightTextClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(BSHistoryActivity.class);
                    }
                })
                .builder();
    }

    @Click({R.id.linear_outside, R.id.linear_indoor})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.linear_indoor:
                startActivity(IndoorActivity.class);
                break;
            case R.id.linear_outside:
                startActivity(GQBSActivity.class);
                break;
        }
    }

}
