package com.jhonlee.sywj.mvp;

import com.jhonlee.lib.network.BaseEntity;
import com.jhonlee.lib.network.BaseObserver;
import com.jhonlee.lib.network.RetrofitFactory;
import com.jhonlee.lib.network.SetThread;
import com.jhonlee.sywj.api.IRequest;
import com.jhonlee.sywj.pojo.Result;
import com.jhonlee.sywj.util.Contract;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class SuccessPresenter {

    private ISuccessView view;

    public void attachView(ISuccessView view){
        this.view = view;
    }

    public void getResult(Map<String,Object> params){
     RetrofitFactory.getInstance(Contract.URL)
             .getApiService(IRequest.class)
             .getRequest(params)
             .compose(SetThread.<BaseEntity<List<Result>>>io_main())
             .subscribe(new BaseObserver<List<Result>>() {
                 @Override
                 protected void onSuccees(BaseEntity<List<Result>> t) throws Exception {
                                view.onSuccess(t.getmData());
                 }
                 @Override
                 protected void onCodeError(BaseEntity<List<Result>> t) throws Exception {

                 }
                 @Override
                 protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                 }
             });
    }
}
