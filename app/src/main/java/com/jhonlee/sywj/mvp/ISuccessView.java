package com.jhonlee.sywj.mvp;

import com.jhonlee.sywj.pojo.Result;

import java.util.List;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public interface ISuccessView {

    void onSuccess(List<Result> results);
}
