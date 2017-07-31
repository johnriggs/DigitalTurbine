package com.johnriggs.digitalturbine.vertical.details.presenter;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenterImpl;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;
import com.johnriggs.digitalturbine.horizontal.utils.JsonToListHelper;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;
import com.johnriggs.digitalturbine.vertical.details.repository.DetailsRepository;
import com.johnriggs.digitalturbine.vertical.details.repository.DetailsRepositoryImpl;
import com.johnriggs.digitalturbine.vertical.details.view.DetailsView;

import org.json.JSONException;

import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public class DetailsPresenterImpl implements DetailsPresenter {
    String appId;
    List<DetailItem> items;

    DetailsRepository repo;
    DetailsView view;

    public DetailsPresenterImpl(DetailsRepository repo){
        this.repo = repo;
    }

    @Override
    public void setView(DetailsView view) {
        this.view = view;
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;

        items = repo.getDetailItems(appId);

        if (items != null){
            view.setupAdsRecyclerView();
        }
    }

    @Override
    public List<DetailItem> getDetailItems() {
        return items;
    }

    @Override
    public Typeface getFont(FontType font) {
        return view.getTypeface(font);
    }
}
