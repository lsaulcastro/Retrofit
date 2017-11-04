package com.example.sauld.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by sauld on 28/10/2017.
 */

public interface itemsService {

    @GET("example/practica.json")
    Call<List<ItemsModelo>> getItems();

    @FormUrlEncoded
    @POST("example/form.php")
    Call<FormResponse> postForm(@Field("name") String name);

}
