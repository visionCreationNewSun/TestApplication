package com.example.testapplication.presenter;

import androidx.annotation.Nullable;

import com.example.testapplication.model.MainModel;
import com.example.testapplication.model.networking.FeedListDTO;
import com.example.testapplication.model.networking.FollowingDTO;
import java.util.ArrayList;

/**
 *    MainPresenter
 */

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    MainModel mainModel =  new MainModel();

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    public MainContract.View getView() {
        return view;
    }

    public void setView(MainContract.View view) {
        this.view = view;
    }

    public MainModel getMainModel() {
        return mainModel;
    }

    public void setMainModel(MainModel mainModel) {
        this.mainModel = mainModel;
    }


    @Override
    public @Nullable ArrayList<FollowingDTO> getFollowingList(String url) {
        return mainModel.getFollowing(url, 1);
    }

    @Override
    public @Nullable ArrayList<FeedListDTO> getFollowingPosts(String url, int page, int userId, boolean isChainging) {

        ArrayList<FeedListDTO> feedList = mainModel.getFeedList(url, page, userId, isChainging);

        // 다른 팔로워로 피드를 바꾸는 것이라면 -> 뷰까지 업뎃 신호를 줘야함
        if (isChainging == true){
            view.showFollowing(feedList);
        }

        return feedList;
    }

    @Override
    public void getPhotoLogPostsInfos(int idx) {

    }
}
