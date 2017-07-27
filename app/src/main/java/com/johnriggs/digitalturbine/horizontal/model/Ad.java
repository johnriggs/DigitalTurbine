package com.johnriggs.digitalturbine.horizontal.model;

import org.simpleframework.xml.Element;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by johnriggs on 7/26/17.
 */

public class Ad extends RealmObject {
    @PrimaryKey
    @Element(name = "appId")
    private String appId;

    @Element(name = "averageRatingImageURL")
    private String averageRatingImageUrl;

    @Element(name = "bidRate")
    private Float bidRate;

    @Element(name = "callToAction")
    private String callToAction;

    @Element(name = "campaignDisplayOrder")
    private Integer campaignDisplayOrder;

    @Element(name = "campaignId")
    private Integer campaignId;

    @Element(name = "campaignTypeId")
    private Integer campaignTypeId;

    @Element(name = "categoryName")
    private String categoryName;

    @Element(name = "clickProxyURL")
    private String clickProxyUrl;

    @Element(name = "creativeId")
    private Integer creativeId;

    @Element(name = "homeScreen")
    private Boolean homeScreen;

    @Element(name = "impressionTrackingURL")
    private String impressionTrackingUrl;

    @Element(name = "isRandomPick")
    private Boolean isRandomPick;

    @Element(name = "minOSVersion", required = false)
    private String minOSVersion;

    @Element(name = "numberOfRatings")
    private String numberOfRatings;

    @Element(name = "productDescription")
    private String productDescription;

    @Element(name = "productId")
    private Integer productId;

    @Element(name = "productName")
    private String productName;

    @Element(name = "productThumbnail")
    private String productThumbnailUrl;

    @Element(name = "rating")
    private Float rating;

    public String getAppId() {
        return appId;
    }

    public String getAverageRatingImageUrl() {
        return averageRatingImageUrl;
    }

    public Float getBidRate() {
        return bidRate;
    }

    public String getCallToAction() {
        return callToAction;
    }

    public Integer getCampaignDisplayOrder() {
        return campaignDisplayOrder;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public Integer getCampaignTypeId() {
        return campaignTypeId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getClickProxyUrl() {
        return clickProxyUrl;
    }

    public Integer getCreativeId() {
        return creativeId;
    }

    public Boolean getHomeScreen() {
        return homeScreen;
    }

    public String getImpressionTrackingUrl() {
        return impressionTrackingUrl;
    }

    public Boolean getRandomPick() {
        return isRandomPick;
    }

    public String getMinOSVersion() {
        return minOSVersion;
    }

    public String getNumberOfRatings() {
        return numberOfRatings;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductThumbnailUrl() {
        return productThumbnailUrl;
    }

    public Float getRating() {
        return rating;
    }
}
