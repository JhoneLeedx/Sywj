package com.jhonlee.sywj.ui.main.fragment;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jhonlee.lib.base.BaseFragment;
import com.jhonlee.lib.ioc.Bind;
import com.jhonlee.lib.ioc.Click;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.mvp.ISuccessView;
import com.jhonlee.sywj.mvp.SuccessPresenter;
import com.jhonlee.sywj.pojo.Result;
import com.jhonlee.sywj.ui.ToolBar;
import com.jhonlee.sywj.ui.bind.BindHouseActivity;
import com.jhonlee.sywj.ui.main.adapter.RecyclerAdapter;
import com.jhonlee.sywj.ui.main.adapter.ViewPagerAdapter;
import com.jhonlee.sywj.ui.online.PaymentActivity;
import com.jhonlee.sywj.ui.online.ReportActivity;
import com.jhonlee.sywj.util.SharedPreferencesUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/1
 * @Version 1.0
 * @Description
 */
public class IndexFragment extends BaseFragment implements ISuccessView {

    @Bind(R.id.viewpager)
    private ViewPager mViewPager;
    @Bind(R.id.recycler)
    private RecyclerView mRecycler;


    //viewpager相关
    private ViewPagerAdapter mAdapter;
    private List<View> mList;
    private int mPosition = 0;

    //recycler相关
    private RecyclerAdapter recyclerAdapter;
    private List<Result> resultList;
    private SuccessPresenter mPresenter;
    @Override
    public int getmResId() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView(View view) {

        ImageView image1 = new ImageView(view.getContext());
        image1.setImageResource(R.drawable.first);
        image1.setLayoutParams(new ViewPager.LayoutParams());
        image1.setScaleType(ImageView.ScaleType.FIT_XY);
        mList.add(image1);
        ImageView image2 = new ImageView(view.getContext());
        image2.setImageResource(R.drawable.second);
        image2.setScaleType(ImageView.ScaleType.FIT_XY);
        image2.setLayoutParams(new ViewPager.LayoutParams());
        mList.add(image2);
        ImageView image3 = new ImageView(view.getContext());
        image3.setImageResource(R.drawable.three);
        image3.setScaleType(ImageView.ScaleType.FIT_XY);
        image3.setLayoutParams(new ViewPager.LayoutParams());
        mList.add(image3);

        mViewPager.setAdapter(mAdapter);
        //    mViewPager.setPageTransformer(true, new ViewPagerTransformer());
        mAdapter.notifyDataSetChanged();
        handler.sendEmptyMessageDelayed(0, 5000);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mPosition = position;
                handler.removeMessages(0);
                handler.sendEmptyMessageDelayed(0, 5000);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRecycler.setAdapter(recyclerAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
        //加载数据
        mPresenter.getResult(getParams());
    }

    @Override
    public void initData() {
        mList = new ArrayList<>();
        mAdapter = new ViewPagerAdapter(mList);

        resultList = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(getActivity(),resultList);
        mPresenter = new SuccessPresenter();
        mPresenter.attachView(this);

    }

    @Override
    public void initTitle(View view) {
        new ToolBar.Builder(getActivity(), (ViewGroup) view)
                .setVisibility(true)
                .setTitle("首页")
                .builder();
    }

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                mPosition++;
                if (mPosition == 3) {
                    mPosition = 0;
                }
                mViewPager.setCurrentItem(mPosition);
                handler.sendEmptyMessageDelayed(0, 5000);
            }
        }
    };

    @Override
    public void onSuccess(List<Result> results) {
        resultList.clear();
        resultList.addAll(results);
        recyclerAdapter.notifyDataSetChanged();
    }

    private class ViewPagerTransformer implements ViewPager.PageTransformer {
        @Override
        public void transformPage(View page, float position) {
            if (position >= -1 && position <= 1) {
                page.setPivotX(position < 0 ? page.getWidth() : 0);//设置要旋转的Y轴的位置
                page.setRotationY(90 * position);//开始设置属性动画值
            }
        }
    }

    @Click({R.id.tv_payment, R.id.tv_report})
    public void ClickView(View view) {
        switch (view.getId()) {
            case R.id.tv_payment:
                if (SharedPreferencesUtil.getFlag(getActivity(),"isbind")){
                    startActivity(PaymentActivity.class);
                }else {
                    startActivity(BindHouseActivity.class);
                }
                break;
            case R.id.tv_report:
                if (SharedPreferencesUtil.getFlag(getActivity(),"isbind")){
                    startActivity(ReportActivity.class);
                }else {
                    startActivity(BindHouseActivity.class);
                }
                break;
        }
    }

    private Map<String,Object> getParams(){
        Map<String,Object> params =new HashMap<>();
        params.put("Class","CommunityNotificationTW");
        params.put("Command","CommunityNotificationTWList");
        params.put("Attribute","%3Cattributes%3E%3CEmpty%3E%3C%2FEmpty%3E%3CCommunityId%3E30de2bf0-7d26-4950-8866-38d317535b67%3C%2FCommunityId%3E%3CCurrPage%3E1%3C%2FCurrPage%3E%3CPageSize%3E10%3C%2FPageSize%3E%3C%2Fattributes%3E");
        params.put("Mac","df3ae63253f5a9cefae16eafeac6a901");

        return params;
    }
}
