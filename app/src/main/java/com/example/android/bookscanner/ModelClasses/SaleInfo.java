package com.example.android.bookscanner.ModelClasses; import com.google.gson.annotations.SerializedName;

;

public class SaleInfo {

    @SerializedName("country")
    private String country;
    @SerializedName("saleability")
    private String saleability;
    @SerializedName("isEbook")
    private Boolean isEbook;

    /**
     * No args constructor for use in serialization
     *
     */
    public SaleInfo() {
    }

    /**
     *
     * @param saleability
     * @param isEbook
     * @param country
     */
    public SaleInfo(String country, String saleability, Boolean isEbook) {
        super();
        this.country = country;
        this.saleability = saleability;
        this.isEbook = isEbook;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSaleability() {
        return saleability;
    }

    public void setSaleability(String saleability) {
        this.saleability = saleability;
    }

    public Boolean getIsEbook() {
        return isEbook;
    }

    public void setIsEbook(Boolean isEbook) {
        this.isEbook = isEbook;
    }

}