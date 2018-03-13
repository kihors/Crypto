package com.example.kihors.crypto.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kihors on 24.02.18.
 */

public class Front {
    private double cap24hrChange;
    @SerializedName("long")
    private String longName;
    private String mktcap;
    private float perc;
    private float price;
    private boolean shapeshift;

    @SerializedName("short")
    private String shortName;
    private long supply;
    private String usdVolume;
    private float volume;
    private float vwapData;
    private float vwapDataBTC;

    public Front(double cap24hrChange, String longName, String mktcap, float perc, float price, boolean shapeshift, String shortName, long supply, String usdVolume, float volume, float vwapData, float vwapDataBTC) {
        this.cap24hrChange = cap24hrChange;
        this.longName = longName;
        this.mktcap = mktcap;
        this.perc = perc;
        this.price = price;
        this.shapeshift = shapeshift;
        this.shortName = shortName;
        this.supply = supply;
        this.usdVolume = usdVolume;
        this.volume = volume;
        this.vwapData = vwapData;
        this.vwapDataBTC = vwapDataBTC;
    }

    public double getCap24hrChange() {
        return cap24hrChange;
    }

    public void setCap24hrChange(double cap24hrChange) {
        this.cap24hrChange = cap24hrChange;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getMktcap() {
        return mktcap;
    }

    public void setMktcap(String mktcap) {
        this.mktcap = mktcap;
    }

    public float getPerc() {
        return perc;
    }

    public void setPerc(float perc) {
        this.perc = perc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isShapeshift() {
        return shapeshift;
    }

    public void setShapeshift(boolean shapeshift) {
        this.shapeshift = shapeshift;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public long getSupply() {
        return supply;
    }

    public void setSupply(long supply) {
        this.supply = supply;
    }

    public String getUsdVolume() {
        return usdVolume;
    }

    public void setUsdVolume(String usdVolume) {
        this.usdVolume = usdVolume;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getVwapData() {
        return vwapData;
    }

    public void setVwapData(float vwapData) {
        this.vwapData = vwapData;
    }

    public float getVwapDataBTC() {
        return vwapDataBTC;
    }

    public void setVwapDataBTC(float vwapDataBTC) {
        this.vwapDataBTC = vwapDataBTC;
    }
}
