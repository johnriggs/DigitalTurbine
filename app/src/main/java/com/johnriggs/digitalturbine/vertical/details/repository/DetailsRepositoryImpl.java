package com.johnriggs.digitalturbine.vertical.details.repository;

import com.google.gson.Gson;
import com.johnriggs.digitalturbine.R;
import com.johnriggs.digitalturbine.horizontal.application.DTApp;
import com.johnriggs.digitalturbine.horizontal.base.repository.BaseRepositoryImpl;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.horizontal.utils.JsonToListHelper;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import io.realm.Realm;

/**
 * Created by johnriggs on 7/26/17.
 */

public class DetailsRepositoryImpl implements DetailsRepository {
    @Override
    public List<DetailItem> getDetailItems(String appId) {
        try {
        return JsonToListHelper.getDetailItemsFromJson(getJsonFromAd(appId));
        } catch (JSONException e){
            e.printStackTrace();
            return null;
        }
    }

    public String getJsonFromAd(String appId) {
        Realm realm = null;
        String jsonString = null;
        try {
            realm = Realm.getDefaultInstance();
            Ad ad = realm.where(Ad.class).equalTo("appId", appId).findFirst();

            Gson gson = new Gson();
            jsonString = gson.toJson(realm.copyFromRealm(ad));
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

        return jsonString;
    }
}
