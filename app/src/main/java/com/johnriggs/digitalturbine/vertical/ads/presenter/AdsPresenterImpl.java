package com.johnriggs.digitalturbine.vertical.ads.presenter;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.application.DTApp;
import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenterImpl;
import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenter;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.horizontal.model.Ads;
import com.johnriggs.digitalturbine.vertical.ads.repository.AdsRepository;
import com.johnriggs.digitalturbine.vertical.ads.view.AdsView;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by johnriggs on 7/25/17.
 */

public class AdsPresenterImpl extends BasePresenterImpl implements AdsPresenter {
    AdsRepository repo;
    AdsView view;

    List<Ad> ads;

    public AdsPresenterImpl(AdsRepository repo){
        this.repo = repo;
        repo.setPresenter(this);
    }

    public void setView(AdsView view){
        this.view = view;

        initializeViews();
    }

    @Override
    public void onAdsReceived(List<Ad> ads) {
        this.ads = ads;

        repo.saveAdsToRealm(ads);
        view.setupAdsRecyclerView();
    }

    @Override
    public void onAdsFailed() {
        Toast.makeText(DTApp.getApp(), DTApp.getApp().getResources().getString(R.string.ads_failed_toast),
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onAdsListItemClicked(Ad ad) {
        view.launchToDetailsView(ad.getAppId());
    }

    @Override
    public List<Ad> getAdsList() {
        return ads;
    }

    @Override
    public PublishSubject<List<Ad>> getAdsReceivedSubject() {
        return repo.getAdsReceivedSubject();
    }

    private void initializeViews(){
        repo.getAdsFromApi();
    }
}
