package com.jhonlee.sywj.mvp;

import com.jhonlee.lib.db.DaoSupportFactory;
import com.jhonlee.lib.network.BaseEntity;
import com.jhonlee.lib.network.BaseObserver;
import com.jhonlee.lib.network.RetrofitFactory;
import com.jhonlee.lib.network.SetThread;
import com.jhonlee.sywj.api.IRequest;
import com.jhonlee.sywj.pojo.City;
import com.jhonlee.sywj.pojo.Result;
import com.jhonlee.sywj.util.Contract;

import java.util.List;
import java.util.Map;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/12/11
 * @Version 1.0
 * @Description
 */
public class CityPresenter {

    private ISuccessCityView view;

    public void attachView(ISuccessCityView view){
        this.view = view;
    }
    public void getResult(Map<String,Object> params){

        List<City> results = DaoSupportFactory.getFactory("sywj").getDao(City.class).querySupport().queryAll();
        if (results!=null){
            view.onSuccess(results);
        }
        RetrofitFactory.getInstance(Contract.URL)
             .getApiService(IRequest.class)
             .getCity(params)
             .compose(SetThread.<BaseEntity<List<City>>>io_main())
             .subscribe(new BaseObserver<List<City>>() {
                 @Override
                 protected void onSuccees(BaseEntity<List<City>> t) throws Exception {
                     DaoSupportFactory.getFactory("sywj").getDao(City.class).clean();
                     DaoSupportFactory.getFactory("sywj").getDao(City.class).insert(t.getmData());
                     view.onSuccess(t.getmData());
                 }
                 @Override
                 protected void onCodeError(BaseEntity<List<City>> t) throws Exception {

                 }
                 @Override
                 protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
                 }
             });
    }
}
