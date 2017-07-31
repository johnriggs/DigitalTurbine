package com.johnriggs.digitalturbine.vertical.details.repository;

import com.johnriggs.digitalturbine.horizontal.base.repository.BaseRepository;
import com.johnriggs.digitalturbine.horizontal.model.Ad;
import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public interface DetailsRepository {
    String getJsonParseErrorMessage();
    List<DetailItem> getDetailItems(String appId);
}
