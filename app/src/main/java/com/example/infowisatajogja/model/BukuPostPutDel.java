package com.example.infowisatajogja.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BukuPostPutDel {
    @SerializedName("buku")
    @Expose
    private Buku mBuku;

    public Buku getmBuku() {
        return mBuku;
    }

    public void setmBuku(Buku mBuku) {
        this.mBuku = mBuku;
    }
}
