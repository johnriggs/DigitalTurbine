package com.johnriggs.digitalturbine.vertical.details.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;
import com.johnriggs.digitalturbine.vertical.details.presenter.DetailsPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johnriggs on 7/26/17.
 */

public class DetailsViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.detail_key)
    TextView key;
    @BindView(R.id.detail_value)
    TextView value;

    Context context;
    DetailsPresenter presenter;
    DetailItem item;

    public DetailsViewHolder(View itemView, DetailsPresenter presenter) {
        super(itemView);
        this.context = itemView.getContext();
        this.presenter = presenter;

        ButterKnife.bind(this, itemView);
    }

    public void bindView(DetailItem item){
        this.item = item;

        key.setText(item.getKey());
        key.setTypeface(presenter.getFont(FontType.ARCHER_BOLD_PRO));

        value.setText(item.getValue());
        value.setTypeface(presenter.getFont(FontType.PROXIMA_SEMIBOLD));
    }
}
