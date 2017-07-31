package com.johnriggs.digitalturbine.vertical.ads.repository;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.application.DTApp;
import com.johnriggs.digitalturbine.horizontal.controllers.RetrofitController;
import com.johnriggs.digitalturbine.horizontal.controllers.RxController;
import com.johnriggs.digitalturbine.horizontal.model.Ad;

import java.util.List;

import io.realm.Realm;
import rx.subjects.PublishSubject;

/**
 * Created by johnriggs on 7/25/17.
 */

public class AdsRepositoryImpl implements AdsRepository {
    @Override
    public void getAdsFromApi() {
        RetrofitController.getAds(DTApp.getApp().getResources().getString(R.string.riggs));
    }

    @Override
    public void saveAdsToRealm(List<Ad> ads) {
        Realm realm = null;

        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(realm1 -> {
                realm1.delete(Ad.class);

                realm1.copyToRealm(ads);
            });
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }

    @Override
    public PublishSubject<List<Ad>> getAdsReceivedSubject() {
        return RxController.getController().getAdsReceivedSubject();
    }
}
