package com.johnriggs.digitalturbine.vertical.ads.view;

import com.johnriggs.digitalturbine.horizontal.base.view.BaseView;
import com.johnriggs.digitalturbine.horizontal.model.Ads;

import java.util.List;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface AdsView extends BaseView{
    void setupAdsRecyclerView();
    void launchToDetailsView(String appId);
}
