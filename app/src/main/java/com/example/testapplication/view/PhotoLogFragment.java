package com.example.testapplication.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testapplication.R;


/**
 *   포토로그를 보여주는 하단 프래그먼트
 */
public class PhotoLogFragment extends Fragment {

    // 뷰 인플레이트
    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.photolog_fragment, container, false);
        return v;
    }
}
