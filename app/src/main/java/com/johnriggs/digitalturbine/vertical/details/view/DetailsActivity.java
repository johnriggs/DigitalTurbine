package com.johnriggs.digitalturbine.vertical.details.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.application.DTApp;
import com.johnriggs.digitalturbine.horizontal.base.view.BaseActivity;
import com.johnriggs.digitalturbine.horizontal.utils.Constants;
import com.johnriggs.digitalturbine.vertical.details.presenter.DetailsPresenter;
import com.johnriggs.digitalturbine.vertical.details.presenter.DetailsPresenterImpl;
import com.johnriggs.digitalturbine.vertical.details.repository.DetailsRepositoryImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johnriggs on 7/26/17.
 */

public class DetailsActivity extends BaseActivity implements DetailsView {
    @BindView(R.id.details_recyclerview)
    RecyclerView detailsRecyclerView;

    String appId;

    DetailsPresenter presenter;

    DetailsListAdapter detailsListAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ButterKnife.bind(this);

        appId = getIntent().getStringExtra(Constants.APP_ID);

        presenter = new DetailsPresenterImpl(new DetailsRepositoryImpl());
        presenter.setView(this);
        presenter.setAppId(appId);
    }

    @Override
    public void setupAdsRecyclerView() {
        detailsRecyclerView.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));
        detailsListAdapter = new DetailsListAdapter(this, presenter);
        detailsRecyclerView.setAdapter(detailsListAdapter);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(DTApp.getApp(), message, Toast.LENGTH_SHORT).show();
    }
}
