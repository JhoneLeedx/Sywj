package com.jhonlee.sywj.ui.online;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jhonlee.lib.base.BaseActivity;
import com.jhonlee.lib.ioc.Bind;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.ui.ToolBar;
import com.jhonlee.sywj.ui.online.adapter.RecyclerStringAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/13
 * @Version 1.0
 * @Description
 */
public class IndoorActivity extends BaseActivity{

    @Bind(R.id.indoor_recycler)
    private RecyclerView mRecycler;

    private List<String> mList;
    private RecyclerStringAdapter mAdapter;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_indoor);
    }

    @Override
    public void initView() {
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        mRecycler.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        mRecycler.setAdapter(mAdapter);

    }

    @Override
    public void initData() {
        mList = new ArrayList<>();
        getListString();
        mAdapter = new RecyclerStringAdapter(this,mList);

    }

    @Override
    public void initTitle() {
        new ToolBar.Builder(this)
                .setTitle("户内报事")
                .builder();
    }
    private void getListString(){
        String s1 = "工程维修";
        String s2 = "环境治理";
        String s3 = "客服服务";
        String s4 = "返修";
        String s5 = "家政服务";
        String s6 = "特约保洁";
        String s7 = "特约绿化";
        mList.add(s1);
        mList.add(s2);
        mList.add(s3);
        mList.add(s4);
        mList.add(s5);
        mList.add(s6);
        mList.add(s7);
     //   mAdapter.notifyDataSetChanged();
    }
}
