package com.example.testapplication.model;

import com.example.testapplication.model.networking.FeedListDTO;
import com.example.testapplication.model.networking.FollowingDTO;
import com.example.testapplication.model.networking.GetFollowingFeeds;
import com.example.testapplication.model.networking.GetFollowingList;
import java.util.ArrayList;


/**
 *   메인 액티비티 model
 */
public class MainModel {


    GetFollowingList getFollowingList;
    GetFollowingFeeds getFollowingFeeds;

    public MainModel() {
        this.getFollowingList = new GetFollowingList();
        this.getFollowingFeeds = new GetFollowingFeeds();
    }



    public GetFollowingList getGetFollowingList() {
        return getFollowingList;
    }

    public void setGetFollowingList(GetFollowingList getFollowingList) {
        this.getFollowingList = getFollowingList;
    }

    // 팔로잉 목록 정보 불러오기
    public ArrayList<FollowingDTO> getFollowing(String url, int page){
        return getFollowingList.httpURLConnectionGet(url, page);
    }

    // 특정 팔로잉 유저 피드 게시글들 불러오기
    public ArrayList<FeedListDTO> getFeedList(String url, int page, int userId, boolean isChainging){
        return getFollowingFeeds.httpURLConnectionGet(url, page, userId);
    }
}
