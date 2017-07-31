package com.johnriggs.digitalturbine.vertical.details.repository;

import com.johnriggs.digitalturbine.vertical.details.model.DetailItem;

import java.util.List;

/**
 * Created by johnriggs on 7/26/17.
 */

public interface DetailsRepository {
    List<DetailItem> getDetailItems(String appId);
}
