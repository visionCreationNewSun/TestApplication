package com.example.testapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapplication.R;
import com.example.testapplication.model.networking.FeedListDTO;
import com.example.testapplication.model.networking.FollowingDTO;
import com.example.testapplication.presenter.MainPresenter;
import com.example.testapplication.utils.ImageUtils;
import com.example.testapplication.view.recyclerview.FeedListAdapter;
import com.example.testapplication.view.recyclerview.FollowingListAdapter;

import java.util.ArrayList;

/**
 *  팔로잉 목록과 게시글을 보여주는 하단 프래그먼트
 */
public class FollowingFragment extends Fragment {

    ArrayList<FollowingDTO> followingUserList;
    ArrayList<FeedListDTO> followingFeedList;
    @Nullable ArrayList<FeedListDTO> chaingingFollowingFeedList;
    MainPresenter mainPresenter;
    String url;
    ImageUtils utils;
    // 팔로잉 목록
    FollowingListAdapter fListAdapter;
    RecyclerView followingListRv;
    // 피드 목록
    FeedListAdapter feedListAdapter;
    RecyclerView feedListRv;

    public FollowingFragment(MainPresenter mainPresenter, String url, ImageUtils utils, @Nullable ArrayList<FeedListDTO> chaingingFollowingFeedList) {
        this.mainPresenter = mainPresenter;
        this.url = url;
        this.utils = utils;
        this.followingUserList = mainPresenter.getFollowingList(url);
        this.chaingingFollowingFeedList = chaingingFollowingFeedList;

        followingFeedList = mainPresenter.getFollowingPosts(url, 0, -1, false); // 처음엔 전체보기로 설정 -1
    }


    // 뷰 인플레이트
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.following_fragment, container, false);
        setRecyclerView();
        return v;
    }

    // 리사이클러뷰 세팅 메서드 (처음은 팔로잉 프래그먼트)
    public void setRecyclerView(){

        // 팔로잉 목록 세팅
        followingUserList = mainPresenter.getFollowingList(url);
        fListAdapter = new FollowingListAdapter(followingUserList, utils, requireContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        followingListRv.setLayoutManager(layoutManager);
        followingListRv.setAdapter(fListAdapter);

        // 피드 게시글 세팅, // 만약 특정 팔로워로 피드를 바꾸는것이 아니라면 targetId -1로 전체보기
        if (chaingingFollowingFeedList == null) followingFeedList
                = mainPresenter.getFollowingPosts(url, 1, -1, false);
        else
        feedListAdapter = new FeedListAdapter(utils, requireContext(), followingFeedList);
        RecyclerView.LayoutManager feedLayoutManager = new GridLayoutManager(requireContext(),2);
        feedListRv.setLayoutManager(feedLayoutManager);
        feedListRv.setAdapter(feedListAdapter);
    }

    // 메모리 해제 필요
}
