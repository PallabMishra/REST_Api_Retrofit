package com.pallab.restapi;

import com.google.gson.annotations.SerializedName;

public class PhotoModel {
    @SerializedName("title")
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullUrl() {
        return fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    @SerializedName("url")
    String fullUrl;
}
