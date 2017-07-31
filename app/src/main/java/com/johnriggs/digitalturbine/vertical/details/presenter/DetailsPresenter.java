package com.johnriggs.digitalturbine.vertical.details.presenter;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenter;
import com.johnriggs.digitalturbine.horizontal.base.view.BaseView;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;
import com.johnriggs.digitalturbine.vertical.details.view.DetailsView;

import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public interface DetailsPresenter{
    void setView(DetailsView view);
    void setAppId(String appId);
    List<DetailItem> getDetailItems();
    Typeface getFont(FontType font);

}
