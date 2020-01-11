package com.example.infowisatajogja.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BukuResult {

}@SerializedName("buku")
@Expose
private List<Buku> bukus = null;

	public List<Buku> getBukus() {
		return bukus;
	}