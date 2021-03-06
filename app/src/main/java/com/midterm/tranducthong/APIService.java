package com.midterm.tranducthong;

import java.util.List;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
//import io.reactivex.Single;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {
    private static final String BASE_URL = "https://api.jsonbin.io/";
    private static ApiInterface api;

    public APIService(){

        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()
                .create(ApiInterface.class);

    }
    public Single<List<ApiModel>> getDogs(){return api.getDogs();}
}