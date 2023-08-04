package com.example.aksubmobilepertemuan5.models;

import com.google.gson.annotations.SerializedName;

public class Webp{

	@SerializedName("small_image_url")
	private String smallImageUrl;

	@SerializedName("image_url")
	private String imageUrl;

	public String getSmallImageUrl(){
		return smallImageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}
}