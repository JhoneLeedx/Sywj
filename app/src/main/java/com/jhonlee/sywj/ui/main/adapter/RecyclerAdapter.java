package com.jhonlee.sywj.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jhonlee.lib.ioc.Bind;
import com.jhonlee.lib.ioc.BindUtils;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.pojo.Result;

import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context mContext;
    private List<Result> mList;

    public RecyclerAdapter(Context mContext, List<Result> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result result = mList.get(position);
        Glide.with(mContext).load(result.getImageUrl()).into(holder.mIvTitle);
        holder.mTvDate.setText(result.getIssueDate());
        holder.mTvTitle.setText(result.getHeading());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_title)
        TextView mTvTitle;
        @Bind(R.id.tv_date)
        TextView mTvDate;
        @Bind(R.id.iv_title)
        ImageView mIvTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            BindUtils.init(itemView, this);
        }
    }
}
