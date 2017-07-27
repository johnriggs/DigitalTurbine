package com.johnriggs.digitalturbine.vertical.details.model;

/**
 * Created by johnriggs on 7/26/17.
 */

public class DetailItem {
    private String key;
    private String value;

    public DetailItem(String key, String value){
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
