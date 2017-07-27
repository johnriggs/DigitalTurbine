package com.johnriggs.digitalturbine.vertical.ads.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.base.view.BaseActivity;
import com.johnriggs.digitalturbine.horizontal.utils.Constants;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenter;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenterImpl;
import com.johnriggs.digitalturbine.vertical.ads.repository.AdsRepositoryImpl;
import com.johnriggs.digitalturbine.vertical.details.view.DetailsActivity;


import butterknife.BindView;
import butterknife.ButterKnife;
import rx.subscriptions.CompositeSubscription;


public class AdsActivity extends BaseActivity implements AdsView {
    @BindView(R.id.ads_recyclerview)
    RecyclerView adsRecyclerView;

    AdsPresenter presenter;

    AdsListAdapter adsListAdapter;

    CompositeSubscription adsSubscription = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);

        ButterKnife.bind(this);

        presenter = new AdsPresenterImpl(new AdsRepositoryImpl());
    }

    @Override
    protected void onStart() {
        super.onStart();

        adsSubscription.add(presenter.getAdsReceivedSubject().subscribe(o -> {
            if (o == null){
                Toast.makeText(AdsActivity.this, getResources().getString(R.string.ads_failed_toast),
                        Toast.LENGTH_LONG).show();
            } else {
                presenter.onAdsReceived(o);
            }
        }));

        presenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (adsSubscription != null){
            adsSubscription.unsubscribe();
        }
    }

    @Override
    public void setupAdsRecyclerView() {
        adsRecyclerView.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));
        adsListAdapter = new AdsListAdapter(this, presenter);
        adsRecyclerView.setAdapter(adsListAdapter);
    }

    @Override
    public void launchToDetailsView(String appId) {
        Intent intent = new Intent(AdsActivity.this, DetailsActivity.class);
        intent.putExtra(Constants.APP_ID, appId);
        startActivity(intent);
    }
}
