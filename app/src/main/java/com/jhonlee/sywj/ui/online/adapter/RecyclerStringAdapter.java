package com.jhonlee.sywj.ui.online.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jhonlee.lib.ioc.Bind;
import com.jhonlee.lib.ioc.BindUtils;
import com.jhonlee.sywj.R;
import com.jhonlee.sywj.ui.online.BSDetailActivity;

import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class RecyclerStringAdapter extends RecyclerView.Adapter<RecyclerStringAdapter.ViewHolder> {

    private Context mContext;
    private List<String> mList;

    public RecyclerStringAdapter(Context mContext, List<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final String string = mList.get(position);
        holder.mTvString.setText(string);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("title",string);
                startActivity(BSDetailActivity.class,bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_string)
        TextView mTvString;


        public ViewHolder(View itemView) {
            super(itemView);
            BindUtils.init(itemView, this);
        }
    }
    private void startActivity(Class clazz, Bundle bundle){
        Intent intent = new Intent(mContext,clazz);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }
}
