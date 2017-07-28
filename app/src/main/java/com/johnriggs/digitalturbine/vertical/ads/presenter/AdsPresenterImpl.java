package com.johnriggs.digitalturbine.vertical.ads.presenter;

import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenterImpl;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
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
    }

    public void setView(AdsView view){
        this.view = view;

        repo.getAdsFromApi();
    }

    @Override
    public void onAdsReceived(List<Ad> ads) {
        this.ads = ads;

        repo.saveAdsToRealm(ads);
        view.setupAdsRecyclerView();
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
}
