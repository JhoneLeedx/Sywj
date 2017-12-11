package com.jhonlee.sywj.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.jhonlee.lib.toolbar.NavToolBar;
import com.jhonlee.sywj.R;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
public class ToolBar extends NavToolBar<ToolBar.Builder.Params>{

    public ToolBar(ToolBar.Builder.Params mParams) {
        super(mParams);
    }

    @Override
    public int bindLayoutId() {
        return R.layout.tool_bar;
    }

    @Override
    public void applyView() {
        setText(R.id.title,getmParams().mTitle);
        setText(R.id.right_text,getmParams().mRightText);

        setOnClickListener(R.id.right_text,getmParams().mRightTextClickListener);
        setOnClickListener(R.id.right_icon,getmParams().mRightIconClickListener);

        setVisibility(R.id.back,getmParams().mVisibility);
        setOnClickListener(R.id.back,getmParams().mLeftClickListener);
        setRightIcon(R.id.right_icon,getmParams().mRightRes);
    }

    public static class Builder extends NavToolBar.Builder{
        Params p;
        public Builder(Context context, ViewGroup parent) {
            p = new Params(context, parent);
        }
        public Builder(Context context) {
            p = new Params(context,null);
        }
        //设置效果
        public Builder setTitle(String tilte) {
            p.mTitle = tilte;
            return this;
        }

        public Builder setRightText(String rightText) {
            p.mRightText = rightText;
            return this;
        }

        public Builder setIcon(int  rightRes) {
            p.mRightRes = rightRes;
            return this;
        }
        public Builder setVisibility(boolean  isVisibility) {
            p.mVisibility = isVisibility;
            return this;
        }

        public Builder setRightIconClickListener(View.OnClickListener rightIconClickListener) {
            p.mRightIconClickListener = rightIconClickListener;
            return this;
        }
        public Builder setRightTextClickListener(View.OnClickListener rightTextClickListener) {
            p.mRightTextClickListener = rightTextClickListener;
            return this;
        }
        public Builder setLeftClickListener(View.OnClickListener leftClickListener) {
            p.mLeftClickListener = leftClickListener;
            return this;
        }

        @Override
        public ToolBar builder() {
            ToolBar bar = new ToolBar(p);
            return bar;
        }
        public static class Params extends NavToolBar.Builder.Params {
            //所有效果的设置
            public String mTitle;
            public String mRightText;
            public View.OnClickListener mRightIconClickListener;
            public View.OnClickListener mRightTextClickListener;
            public View.OnClickListener mLeftClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((Activity)mContext).finish();
                }
            };
            public int mRightRes;
            public boolean mVisibility = false;

            public Params(Context context, ViewGroup parent) {
                super(context, parent);
            }

        }
    }
}
