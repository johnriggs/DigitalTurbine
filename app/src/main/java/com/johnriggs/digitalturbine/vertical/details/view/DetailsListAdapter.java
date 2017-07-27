package com.johnriggs.digitalturbine.vertical.details.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenter;
import com.johnriggs.digitalturbine.vertical.ads.view.AdsViewHolder;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;
import com.johnriggs.digitalturbine.vertical.details.presenter.DetailsPresenter;

import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public class DetailsListAdapter extends RecyclerView.Adapter<DetailsViewHolder> {

    Context context;
    List<DetailItem> items;
    DetailsPresenter presenter;

    public DetailsListAdapter(Context context, DetailsPresenter presenter){
        this.context = context;
        this.presenter = presenter;
        items = presenter.getDetailItems();
    }

    @Override
    public DetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_details_list, parent, false);

        return new DetailsViewHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(DetailsViewHolder holder, int position) {
        holder.bindView(items.get(position));
    }

    @Override
    public int getItemCount() {
        return (items != null ? items.size() : 0);
    }
}
