package com.johnriggs.digitalturbine.vertical.ads.view;

import com.johnriggs.digitalturbine.horizontal.base.view.BaseView;

/**
 * Created by johnriggs on 7/25/17.
 */

public interface AdsView extends BaseView{
    void setupAdsRecyclerView();
    void launchToDetailsView(String appId);
}
