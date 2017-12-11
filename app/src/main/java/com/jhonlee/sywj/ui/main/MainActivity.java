package com.jhonlee.sywj.ui.main;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.jhonlee.lib.base.BaseActivity;
import com.jhonlee.lib.ioc.Bind;
import com.jhonlee.lib.ioc.Click;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.ui.main.fragment.IndexFragment;
import com.jhonlee.sywj.ui.main.fragment.LeaseFragment;
import com.jhonlee.sywj.ui.main.fragment.LifeFragment;
import com.jhonlee.sywj.ui.main.fragment.UserFragment;

public class MainActivity extends BaseActivity {

    @Bind(R.id.rb_home)
    private RadioButton mRbHome;

    private Fragment isShowFragment;
    private Fragment mIndexFragmnet;
    private Fragment mLeaseFragmnet;
    private Fragment mLifeFragmnet;
    private Fragment mUserFragmnet;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        mRbHome.setChecked(true);

        if (mRbHome.isChecked()) {
            getFragmentManager().beginTransaction().add(R.id.center_frame, isShowFragment).commit();
        }
    }

    @Override
    public void initData() {
        mIndexFragmnet = new IndexFragment();
        mLeaseFragmnet = new LeaseFragment();
        mLifeFragmnet = new LifeFragment();
        mUserFragmnet = new UserFragment();
        isShowFragment = mIndexFragmnet;
    }

    @Override
    public void initTitle() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isShowFragment = null;
        mIndexFragmnet = null;
        mLeaseFragmnet = null;
        mLifeFragmnet = null;
        mUserFragmnet = null;
    }

    @Click({R.id.rb_home, R.id.rb_lease, R.id.rb_life, R.id.rb_user})
    public void Click(View view) {
        switch (view.getId()) {
            case R.id.rb_home:
                switchContent(isShowFragment, mIndexFragmnet);
                break;
            case R.id.rb_lease:
                switchContent(isShowFragment, mLeaseFragmnet);
                break;
            case R.id.rb_life:
                switchContent(isShowFragment, mLifeFragmnet);
                break;
            case R.id.rb_user:
                switchContent(isShowFragment, mUserFragmnet);
                break;
        }
    }

    private void switchContent(Fragment from, Fragment to) {
        if (isShowFragment != to) {
            isShowFragment = to;
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            if (!to.isAdded()) {
                fragmentTransaction.hide(from).add(R.id.center_frame, to).commit();
            } else {
                fragmentTransaction.hide(from).show(to).commit();
            }
        }
    }
}
