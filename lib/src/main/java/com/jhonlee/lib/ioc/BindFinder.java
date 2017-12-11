package com.jhonlee.lib.ioc;

import android.app.Activity;
import android.view.View;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
public class BindFinder {

    private Activity mActivity;
    private View mView;

    public BindFinder(Activity mActivity) {
        this.mActivity = mActivity;
    }

    public BindFinder(View mView) {
        this.mView = mView;
    }

    public View findViewByid(int viewId) {
        return mActivity != null ? mActivity.findViewById(viewId) : mView.findViewById(viewId);
    }
}
