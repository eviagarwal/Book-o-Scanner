package com.example.android.bookscanner.ModelClasses;

import com.google.gson.annotations.SerializedName;
import java.util.List;


public class JsonResponse {

    @SerializedName("kind")
    private String kind;
    @SerializedName("totalItems")
    private Integer totalItems;
    @SerializedName("items")
    private List<Item> items = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public JsonResponse() {
    }

    /**
     *
     * @param items
     * @param totalItems
     * @param kind
     */
    public JsonResponse(String kind, Integer totalItems, List<Item> items) {
        super();
        this.kind = kind;
        this.totalItems = totalItems;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}