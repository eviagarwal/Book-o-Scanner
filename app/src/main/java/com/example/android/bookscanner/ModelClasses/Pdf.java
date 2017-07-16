package com.example.android.bookscanner.ModelClasses;

import com.google.gson.annotations.SerializedName;


public class Pdf {

    @SerializedName("isAvailable")
    private Boolean isAvailable;

    /**
     * No args constructor for use in serialization
     *
     */
    public Pdf() {
    }

    /**
     *
     * @param isAvailable
     */
    public Pdf(Boolean isAvailable) {
        super();
        this.isAvailable = isAvailable;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

}