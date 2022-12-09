package com.example.testapplication.view.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.testapplication.R;
import com.example.testapplication.model.networking.FeedListDTO;
import com.example.testapplication.utils.ImageUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import java.util.ArrayList;


/**
 *   피드 목록을 표시하기 위한 리사이클러뷰 어댑터
 */

public class FeedListAdapter extends RecyclerView.Adapter<FeedListAdapter.FeedListViewHolder> {

    ImageUtils utils;
    Context context;
    ArrayList<FeedListDTO> feedList;
    ArrayList<String> feedListUrl;

    public FeedListAdapter(ImageUtils utils, Context context, ArrayList<FeedListDTO> feedList) {
        this.utils = utils;
        this.context = context;
        this.feedList = feedList;

        feedListUrl = new ArrayList<String>();
        try{
            for (int i=0; i<feedList.size(); i++){
                feedListUrl.add(feedList.get(1).getImageUrl().getString(i));
            }
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }


    @NonNull
    @NotNull
    @Override
    public FeedListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.following_posts_recycler_item, parent, false);
        return new FeedListAdapter.FeedListViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull @NotNull FeedListViewHolder holder, int position) {
        holder.setItem(feedListUrl.get(position));
    }


    @Override
    public int getItemCount() {
        return feedList.size();
    }

    // 뷰홀더
    class FeedListViewHolder extends RecyclerView.ViewHolder {
        private ImageView feedImage;


        public FeedListViewHolder(@NonNull View itemView){
            super(itemView);
            feedImage = itemView.findViewById(R.id.feed_image_view);
        }

        public void setItem(String imageUrl) {
            // 피드 이미지 삽입
            utils.setImage(feedImage, imageUrl, context);
        }
    }
}
