package com.johnriggs.digitalturbine.vertical.ads.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.horizontal.model.Ads;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenter;

import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public class AdsListAdapter extends RecyclerView.Adapter<AdsViewHolder> {

    Context context;
    List<Ad> ads;
    AdsPresenter presenter;

    public AdsListAdapter(Context context, AdsPresenter presenter){
        this.context = context;
        this.presenter = presenter;
        ads = presenter.getAdsList();
    }

    @Override
    public AdsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_ads_list, parent, false);

        return new AdsViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(AdsViewHolder holder, int position) {
        holder.bindView(ads.get(position));
    }

    @Override
    public int getItemCount() {
        return (ads != null ? ads.size() : 0);
    }
}
