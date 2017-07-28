package com.johnriggs.digitalturbine.vertical.ads.repository;

import com.johnriggs.digitalturbine.horizontal.base.repository.BaseRepository;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.horizontal.model.Ads;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenter;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface AdsRepository extends BaseRepository{
    void getAdsFromApi();
    void saveAdsToRealm(List<Ad> ads);
    PublishSubject<List<Ad>> getAdsReceivedSubject();
}
