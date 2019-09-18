package com.example.postretrofit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Mobile implements Serializable {
@SerializedName("productname")
    String productName;
@SerializedName("pid")
    String productId;
@SerializedName("oldprice")
    String oldPrice ;
@SerializedName("newprice")
    String newPrice ;
@SerializedName("discount")
    String discount ;
@SerializedName("image1")
    String imageUrl;

    public Mobile(String productName, String productId, String oldPrice, String newPrice, String discount, String imageUrl) {
        this.productId = productId;
        this.oldPrice = oldPrice;
        this.newPrice = newPrice;
        this.discount = discount;
        this.imageUrl = imageUrl;
        this.productName =productName;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
