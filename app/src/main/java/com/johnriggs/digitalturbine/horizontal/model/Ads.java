package com.johnriggs.digitalturbine.horizontal.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by johnriggs on 7/25/17.
 */

@Root(name = "ads")
public class Ads {
    @ElementList(inline = true, required = true)
    private List<Ad> ads;

    @Element(name = "responseTime")
    private String responseTime;

    @Element(name = "serverId")
    private String serverId;

    @Element(name = "totalCampaignsRequested")
    private Integer totalCampaignsRequested;

    @Element(name = "version")
    private String version;

    public Ads(){}

    public List<Ad> getAds() {
        return ads;
    }
}
