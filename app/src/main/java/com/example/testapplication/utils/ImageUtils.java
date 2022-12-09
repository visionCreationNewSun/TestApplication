package com.example.testapplication.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 *   이미지 관련 유틸
 */
public class ImageUtils {

    // glide로 이미지를 받아온다
    public void setImage(ImageView imgV, String photoUrl, Context context){
        Glide.with(context)
                .load(photoUrl)
                .into(imgV);
    }
}
