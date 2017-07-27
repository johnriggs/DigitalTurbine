package com.johnriggs.digitalturbine.vertical.details.repository;

import com.johnriggs.digitalturbine.horizontal.base.repository.BaseRepository;
import com.johnriggs.digitalturbine.horizontal.model.Ad;

import org.json.JSONObject;

/**
 * Created by johnriggs on 7/26/17.
 */

public interface DetailsRepository extends BaseRepository{
    String getJsonFromAd(String appId);
    String getJsonParseErrorMessage();
}
