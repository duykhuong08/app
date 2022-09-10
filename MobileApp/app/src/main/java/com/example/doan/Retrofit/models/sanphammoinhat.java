package com.example.doan.Retrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class sanphammoinhat {
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("tensanpham")
    @Expose
    private String tensanpham;
    @SerializedName("giasanpham")
    @Expose
    private int giasanpham;
    @SerializedName("hinhanhsanpham")
    @Expose
    private String hinhanhsanpham;
    @SerializedName("motasanpham")
    @Expose
    private String motasanpham;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTensanpham() {
        return tensanpham;
    }

    public void setTensanpham(String tensp) {
        this.tensanpham = tensp;
    }
    public int getGiasanpham() {
        return giasanpham;
    }

    public void setGiasanpham(int gia) {
        this.giasanpham = gia;
    }

    public String getHinhanhsanpham() {
        return hinhanhsanpham;
    }

    public void setHinhanhsanpham(String hinhanh) {
        this.hinhanhsanpham = hinhanh;
    }
    public String getMotasanpham() {
        return motasanpham;
    }

    public void setMotasanpham(String mota) {
        this.motasanpham = mota;
    }
}
