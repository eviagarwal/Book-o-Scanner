package com.example.android.bookscanner.ModelClasses;

import com.google.gson.annotations.SerializedName;


public class ReadingModes {

    @SerializedName("text")
    private Boolean text;
    @SerializedName("image")
    private Boolean image;

    /**
     * No args constructor for use in serialization
     *
     */
    public ReadingModes() {
    }

    /**
     *
     * @param text
     * @param image
     */
    public ReadingModes(Boolean text, Boolean image) {
        super();
        this.text = text;
        this.image = image;
    }

    public Boolean getText() {
        return text;
    }

    public void setText(Boolean text) {
        this.text = text;
    }

    public Boolean getImage() {
        return image;
    }

    public void setImage(Boolean image) {
        this.image = image;
    }

}