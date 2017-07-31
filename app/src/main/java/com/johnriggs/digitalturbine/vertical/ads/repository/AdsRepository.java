package com.johnriggs.digitalturbine.vertical.ads.repository;

import com.johnriggs.digitalturbine.horizontal.model.Ad;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface AdsRepository {
    void getAdsFromApi();
    void saveAdsToRealm(List<Ad> ads);
    PublishSubject<List<Ad>> getAdsReceivedSubject();
}
