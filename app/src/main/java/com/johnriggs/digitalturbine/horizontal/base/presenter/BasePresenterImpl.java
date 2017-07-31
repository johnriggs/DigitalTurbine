package com.johnriggs.digitalturbine.horizontal.base.presenter;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenter;
import com.johnriggs.digitalturbine.horizontal.base.repository.BaseRepository;
import com.johnriggs.digitalturbine.horizontal.base.view.BaseView;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;

/**
 * Created by johnriggs on 7/25/17.
 */

public class BasePresenterImpl implements BasePresenter {
    BaseRepository repo;
    BaseView view;

    public BasePresenterImpl(BaseRepository repo){
        this.repo = repo;
    }

    @Override
    public void setView(BaseView view) {
        this.view = view;
    }

    @Override
    public Typeface getFont(FontType font) {
        return repo.getFont(font);
    }
}
