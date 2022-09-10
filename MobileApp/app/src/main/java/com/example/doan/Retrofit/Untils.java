package com.example.doan.Retrofit;

public class Untils {
    public static final String Base_Url = "https://localhost:44371/api/";
    // nhan va gui du lieu
    public static API getData() {
        return RetrofitClient.getClient(Base_Url).create(API.class);
    }
}
