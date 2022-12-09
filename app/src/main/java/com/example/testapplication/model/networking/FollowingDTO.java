package com.example.testapplication.model.networking;

/**
 *    팔로잉 목록 dto
 */
public class FollowingDTO {

    int userId;
    String photoUrl;
    String nickname;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public FollowingDTO(int userId, String photoUrl, String nickname) {
        this.userId = userId;
        this.photoUrl = photoUrl;
        this.nickname = nickname;

    }



}
