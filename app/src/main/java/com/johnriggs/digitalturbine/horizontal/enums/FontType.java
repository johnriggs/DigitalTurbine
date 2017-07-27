package com.johnriggs.digitalturbine.horizontal.enums;

/**
 * Created by johnriggs on 7/26/17.
 */

public enum FontType {
    ARCHER_BOLD_PRO("archerBoldPro", 0),
    PROXIMA_SEMIBOLD("proximaSemiBold", 1);

    public String name;
    public int id;

    FontType(String name, int id){
        this.name = name;
        this.id = id;
    }
}
