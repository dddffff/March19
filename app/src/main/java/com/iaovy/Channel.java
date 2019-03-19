package com.iaovy;

import java.io.Serializable;

public class Channel implements Serializable {
    private String title;
    private String quality;
    private String url;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }


    public void setUrl(String url) {
        this.url = url;
    }
}
