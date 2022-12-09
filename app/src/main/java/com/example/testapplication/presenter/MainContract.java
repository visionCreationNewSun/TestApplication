package com.example.testapplication.presenter;

import androidx.annotation.Nullable;

import com.example.testapplication.model.networking.FeedListDTO;
import com.example.testapplication.model.networking.FollowingDTO;

import java.util.ArrayList;
import java.util.Map;

/**
 *   MainContract
 */
public interface MainContract {

    // 화면에 표시하기 위한 인터페이스 모델 -> 프레젠터 -> 뷰
    interface View {
        // 팔로잉한 사람들 목록과 포스트를 표시하기 위함
        void showFollowing(ArrayList<FeedListDTO> feedList);
        // 포토로그 게시글 하나당 정보 목록
        void showPhotoLogList();
    }


    //  뷰 -> 프리젠터 -> 모델
    interface Presenter{
        @Nullable
        ArrayList<FollowingDTO> getFollowingList(String url);
        @Nullable
        ArrayList<FeedListDTO> getFollowingPosts(String url, int page, int userId, boolean isChainging);
        void getPhotoLogPostsInfos(int idx);
    }
}
