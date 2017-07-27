package com.johnriggs.digitalturbine.vertical.ads.presenter;

import com.johnriggs.digitalturbine.horizontal.base.presenter.BasePresenter;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.horizontal.model.Ads;
import com.johnriggs.digitalturbine.vertical.ads.view.AdsView;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface AdsPresenter extends BasePresenter{
    void setView(AdsView view);
    void onAdsReceived(List<Ad> ads);
    void onAdsFailed();
    void onAdsListItemClicked(Ad ad);
    List<Ad> getAdsList();
    PublishSubject<List<Ad>> getAdsReceivedSubject();
}
