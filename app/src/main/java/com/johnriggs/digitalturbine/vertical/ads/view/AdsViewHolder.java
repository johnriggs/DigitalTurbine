package com.johnriggs.digitalturbine.vertical.ads.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.enums.FontType;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.vertical.ads.presenter.AdsPresenter;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by johnriggs on 7/26/17.
 */

public class AdsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    @BindView(R.id.ad_thumbnail)
    ImageView adThumbnail;
    @BindView(R.id.ad_name)
    TextView adName;
    @BindView(R.id.ad_rating)
    ImageView adRating;
    @BindView(R.id.ad_description)
    TextView adDescription;
    @BindView(R.id.ad_rating_title)
    TextView adRatingTitle;
    @BindView(R.id.ad_rating_numeral)
    TextView adRatingNumeral;

    Context context;
    AdsPresenter presenter;
    Ad ad;

    public AdsViewHolder(View itemView, AdsPresenter presenter) {
        super(itemView);
        this.context = itemView.getContext();
        this.presenter = presenter;

        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
    }

    public void bindView(Ad ad){
        this.ad = ad;

        Picasso.with(context).load(ad.getProductThumbnailUrl()).into(adThumbnail);
        Picasso.with(context).load(ad.getAverageRatingImageUrl()).into(adRating);

        adName.setText(ad.getProductName());
        adName.setTypeface(presenter.getFont(FontType.ARCHER_BOLD_PRO));

        adRatingTitle.setTypeface(presenter.getFont(FontType.PROXIMA_SEMIBOLD));

        adRatingNumeral.setText("(" + ad.getRating() + ")");
        adRatingNumeral.setTypeface(presenter.getFont(FontType.PROXIMA_SEMIBOLD));

        adDescription.setText(ad.getProductDescription());
        adDescription.setTypeface(presenter.getFont(FontType.PROXIMA_SEMIBOLD));
    }

    @Override
    public void onClick(View v) {
        presenter.onAdsListItemClicked(ad);
    }
}
