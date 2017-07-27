package com.johnriggs.digitalturbine.horizontal.utils;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.application.DTApp;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;

/**
 * Created by johnriggs on 7/26/17.
 */

public class FontHelper {
    private static FontHelper helper;

    private static Typeface archerBoldPro;
    private static Typeface proximaSemiBold;

    private FontHelper(){
        archerBoldPro = Typeface.createFromAsset(DTApp.getApp().getAssets(),"fonts/Archer-Bold-Pro.otf");
        proximaSemiBold = Typeface.createFromAsset(DTApp.getApp().getAssets(),"fonts/ProximaNova-Semibold.otf");
    }

    public synchronized static FontHelper getHelper(){
        if (helper == null){
            helper = new FontHelper();
        }

        return helper;
    }

    public Typeface getFontTypeface(FontType font){
        switch (font){
            case ARCHER_BOLD_PRO:
                return archerBoldPro;
            case PROXIMA_SEMIBOLD:
                return proximaSemiBold;
            default:
                return proximaSemiBold;
        }
    }
}
