package com.johnriggs.digitalturbine.horizontal.base.repository;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.base.repository.BaseRepository;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;
import com.johnriggs.digitalturbine.horizontal.utils.FontHelper;

/**
 * Created by johnriggs on 7/25/17.
 */

public class BaseRepositoryImpl implements BaseRepository {
    @Override
    public Typeface getFont(FontType font) {
        return FontHelper.getHelper().getFontTypeface(font);
    }
}
