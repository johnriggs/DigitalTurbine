package com.johnriggs.digitalturbine.horizontal.controllers;

import android.util.Log;

import com.johnriggs.digitalturbine.horizontal.model.Ads;
import com.johnriggs.digitalturbine.horizontal.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by johnriggs on 7/25/17.
 */

public class RetrofitController {
    public static final String BASE_URL_API = "http://ads.appia.com";
    public static final String TAG = "RETROFIT";

    static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .client(new OkHttpClient())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build();

    public interface APIService {
        @POST(Constants.ADS_API)
        @FormUrlEncoded
        Call<Ads> getAds(@Field(Constants.LAST_NAME) String lastName);
    }

    public static void getAds(String lastName){
        APIService apiInterface = retrofit.create(APIService.class);
        Call<Ads> call = apiInterface.getAds(lastName);
        call.enqueue(new Callback<Ads>() {
            @Override
            public void onResponse(Call<Ads>call, Response<Ads> response) {
                if (response.errorBody() == null){
                    RxController.getController().notifyAdsReceived(response.body().getAds());
                } else {
                    Log.d(TAG, "GetAdsCallError Code: " + response.code() + " " + response.message());
                    RxController.getController().notifyAdsReceived(null);
                }
            }

            @Override
            public void onFailure(Call<Ads> call, Throwable t) {
                Log.d(TAG, "GetAdsCallFailure " + t .getMessage());
            }
        });
    }
}
