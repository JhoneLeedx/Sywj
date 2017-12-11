package com.jhonlee.sywj.api;

import com.jhonlee.lib.network.BaseEntity;
import com.jhonlee.sywj.pojo.Result;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public interface IRequest {

    @GET("Service.ashx")
    Observable<BaseEntity<List<Result>>> getRequest(@QueryMap Map<String,Object> params);
}
