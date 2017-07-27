package com.johnriggs.digitalturbine.horizontal.base.presenter;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.base.view.BaseView;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface BasePresenter {
    void setView(BaseView view);
    Typeface getFont(FontType font);
}
