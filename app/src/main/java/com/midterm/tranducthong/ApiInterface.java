package com.midterm.tranducthong;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("b/625039f3d20ace068f9580fb")
    Single<List<ApiModel>> getDogs();
}
