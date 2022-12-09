package com.example.testapplication.model.networking;

import org.json.JSONArray;

/**
 *   피드 목록 dto
 */
public class FeedListDTO {

    int feedId;
    JSONArray imageUrl;
    String type;


    public int getFeedId() {
        return feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }

    public JSONArray getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(JSONArray imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FeedListDTO(int feedId, JSONArray imageUrl, String type) {
        this.feedId = feedId;
        this.imageUrl = imageUrl;
        this.type = type;
    }
}
