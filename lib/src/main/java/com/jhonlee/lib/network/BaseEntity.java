package com.jhonlee.lib.network;

import com.google.gson.annotations.SerializedName;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/11/21
 * @Version 1.0
 * @Description  接口基类
 */
public class BaseEntity<T> {

    @SerializedName("Result")
    private boolean mResult;
    @SerializedName("data")
    private T mData;

    public boolean isSuccess(){
        return mResult;
    }

    public void setmResult(boolean mResult) {
        this.mResult = mResult;
    }

    public T getmData() {
        return mData;
    }

    public void setmData(T mData) {
        this.mData = mData;
    }
}
