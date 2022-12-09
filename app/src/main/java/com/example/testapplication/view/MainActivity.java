package com.example.testapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testapplication.MyApplication;
import com.example.testapplication.R;
import com.example.testapplication.model.networking.FeedListDTO;
import com.example.testapplication.model.networking.FollowingDTO;
import com.example.testapplication.model.networking.GetFollowingList;
import com.example.testapplication.presenter.MainContract;
import com.example.testapplication.presenter.MainPresenter;
import com.example.testapplication.utils.ImageUtils;
import com.example.testapplication.view.recyclerview.FollowingListAdapter;

import java.util.ArrayList;
import java.util.Map;

/**
 *   메인 액티비티
 */
public class MainActivity extends AppCompatActivity implements MainContract.View {

    String url;
    MainPresenter presenter;
    FragmentManager fragManager;
    FollowingFragment follwingFrag;
    PhotoLogFragment photoLogFragment;
    ImageUtils imgUtils;
    Button photoLogButton;
    Button followingButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 프로퍼티 초기화
        initializing();

        // 첫 하단 프래그먼트 초기화
        fragManager.beginTransaction()
                .add(R.id.fragment_container_view, FollowingFragment.class, null)
                .commit();


        // 버튼 리스너 (하단 프래그먼트 전환)
        followingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragManager.beginTransaction().show(follwingFrag);  // 보충필요
            }
        });

        photoLogButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragManager.beginTransaction().show(photoLogFragment);
            }
        });
    }


    @Override
    public void showFollowing(ArrayList<FeedListDTO> feedList){
        follwingFrag = new FollowingFragment(presenter, url, imgUtils, feedList);
        fragManager.beginTransaction().show(follwingFrag);
    }

    @Override
    public void showPhotoLogList(){

    }

    // 프로퍼티 초기화 메서드
    public void initializing(){
        url = ((MyApplication) getApplication()).getUrl();
        presenter = new MainPresenter(this);
        fragManager = getSupportFragmentManager();
        follwingFrag = new FollowingFragment(presenter, url, imgUtils, null);
        photoLogFragment = new PhotoLogFragment();
        imgUtils = new ImageUtils();
        followingButton = findViewById(R.id.bt_following);
        photoLogButton = findViewById(R.id.bt_photo_log);
    }

    @Override
    protected void onStop() {
        super.onStop();
        url = null;
        presenter = null;
        fragManager = null;
        photoLogFragment = null;
        imgUtils = null;
        followingButton = null;
        photoLogButton = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (url != null) url = null;
        if (presenter != null) presenter = null;
        if (fragManager != null) fragManager = null;
        if (photoLogFragment != null) photoLogFragment = null;
        if (imgUtils != null) imgUtils = null;
        if (followingButton != null) followingButton = null;
        if (photoLogButton != null) photoLogButton = null;
    }
}