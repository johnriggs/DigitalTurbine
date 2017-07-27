package com.johnriggs.digitalturbine.horizontal.base.repository;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.enums.FontType;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface BaseRepository {
    Typeface getFont(FontType font);
}
