package com.jhonlee.sywj.ui.bind;

import com.jhonlee.lib.base.BaseActivity;
import com.jhonlee.lib.ioc.Click;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.ui.ToolBar;
import com.jhonlee.sywj.ui.online.PaymentActivity;
import com.jhonlee.sywj.util.SharedPreferencesUtil;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/12
 * @Version 1.0
 * @Description
 */
public class BindNextActivity extends BaseActivity {
    @Override
    public void setContentView() {
        setContentView(R.layout.activity_bind_next);
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
    @Click(R.id.btn_commit)
    public void commit(){
        SharedPreferencesUtil.setFlag(this,"isbind",true);
        startActivity(PaymentActivity.class);
        finish();
    }
}
