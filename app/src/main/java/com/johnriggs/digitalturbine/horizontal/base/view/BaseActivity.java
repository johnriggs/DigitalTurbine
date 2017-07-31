package com.johnriggs.digitalturbine.horizontal.base.view;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenter;
import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenterImpl;
import com.johnriggs.digitalturbine.horizontal.base.repository.BaseRepositoryImpl;
import com.johnriggs.digitalturbine.horizontal.base.view.BaseView;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;

/**
 * Created by johnriggs on 7/25/17.
 */

public class BaseActivity extends AppCompatActivity implements BaseView {
    BasePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new BasePresenterImpl(new BaseRepositoryImpl());
        presenter.setView(this);
    }

    @Override
    public Typeface getTypeface(FontType font){
        return presenter.getFont(font);
    }
}
