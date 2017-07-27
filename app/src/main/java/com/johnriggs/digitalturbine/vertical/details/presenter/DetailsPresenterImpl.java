package com.johnriggs.digitalturbine.vertical.details.presenter;

import android.widget.Toast;

import com.johnriggs.digitalturbine.horizontal.application.DTApp;
import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenterImpl;
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

public class DetailsPresenterImpl extends BasePresenterImpl implements DetailsPresenter {
    String appId;
    List<DetailItem> items;

    DetailsRepository repo;
    DetailsView view;

    public DetailsPresenterImpl(DetailsRepositoryImpl repo){
        this.repo = repo;
    }

    @Override
    public void setView(DetailsView view) {
        this.view = view;

        initializeViews();
    }

    @Override
    public void setAppId(String appId) {
        this.appId = appId;

        try {
            items = JsonToListHelper.getDetailItemsFromJson(repo.getJsonFromAd(appId));
        } catch (JSONException e){
            Toast.makeText(DTApp.getApp(), "There was an error parsing the data for this item", Toast.LENGTH_SHORT).show();
        }

        if (items != null){
            view.setupAdsRecyclerView();
        }
    }

    @Override
    public List<DetailItem> getDetailItems() {
        return items;
    }

    private void initializeViews(){

    }
}
