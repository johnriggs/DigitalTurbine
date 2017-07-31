package com.johnriggs.digitalturbine.vertical.ads.presenter;

import android.graphics.Typeface;

import com.johnriggs.digitalturbine.horizontal.enums.FontType;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.vertical.ads.view.AdsView;

import java.util.List;

import rx.subjects.PublishSubject;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface AdsPresenter {
    void setView(AdsView view);
    void onAdsReceived(List<Ad> ads);
    void onAdsListItemClicked(Ad ad);
    List<Ad> getAdsList();
    PublishSubject<List<Ad>> getAdsReceivedSubject();
    Typeface getFont(FontType font);
}
