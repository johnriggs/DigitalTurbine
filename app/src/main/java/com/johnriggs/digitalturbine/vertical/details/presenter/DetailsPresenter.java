package com.johnriggs.digitalturbine.vertical.details.presenter;

import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenter;
import com.johnriggs.digitalturbine.horizontal.base.view.BaseView;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;
import com.johnriggs.digitalturbine.vertical.details.view.DetailsView;

import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public interface DetailsPresenter extends BasePresenter {
    void setView(DetailsView view);
    void setAppId(String appId);
    List<DetailItem> getDetailItems();
}
