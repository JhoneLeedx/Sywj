package com.jhonlee.lib.network;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author <font color="pink"><b>JhoneLee</b></font>
 * @Date 2017/11/21
 * @Version 1.0
 * @Description
 */
public class RetrofitFactory {

    private static RetrofitFactory INSTANCE;
    private Retrofit mRetrofit;

    private RetrofitFactory(String url) {

        //初始化retrofit

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build();
        getClient();

    }

    public static RetrofitFactory getInstance(String url) {
        if (INSTANCE == null) {
            INSTANCE = new RetrofitFactory(url);
        }
        return INSTANCE;
    }

    public <T> T getApiService(Class<T> clazz) {
        return mRetrofit.create(clazz);
    }

    //设置OKhttp 相关配置
    private OkHttpClient getClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtil.d("http请求", message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient
                .Builder()
                .connectTimeout(5000, TimeUnit.SECONDS)//设置连接超时
                .addInterceptor(interceptor)
                .build();
        return client;
    }

}

