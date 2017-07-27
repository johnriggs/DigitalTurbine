package com.johnriggs.digitalturbine.horizontal.utils;

import android.support.annotation.Nullable;
import android.util.Log;

import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public class JsonToListHelper {
    public static List<DetailItem> getDetailItemsFromJson(String jsonString) throws JSONException {
        List<DetailItem> items = new ArrayList<>();

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(jsonString);
            Iterator<String> iterator = jsonObject.keys();

            while (iterator.hasNext()){
                String key = iterator.next();
                Object obj = jsonObject.get(key);

                String value = null;
                if (obj instanceof String){
                    value = (String) obj;
                } else {
                    value = String.valueOf(obj);
                }

                items.add(new DetailItem(key, value));
            }

        } catch (JSONException e){
            Log.d("JSON_ERROR", e.getMessage());
        }

        return items;
    }
}
