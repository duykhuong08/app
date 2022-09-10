package com.example.doan.Retrofit;

import com.example.doan.Retrofit.models.sanphammoinhat;

import com.example.doan.model.users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface  API {


    @FormUrlEncoded
    @POST("/account/login")
    Call<String> Logindata (@Field("Username") String taikhoan
            , @Field("Password") String matkhau);


}
