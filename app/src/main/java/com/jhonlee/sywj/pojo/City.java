package com.jhonlee.sywj.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class City {

    @SerializedName("City")
    private String mCity;

    public String getmCity() {
        return mCity;
    }

    public void setmCity(String mCity) {
        this.mCity = mCity;
    }
}
