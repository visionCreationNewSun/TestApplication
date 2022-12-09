package com.example.testapplication.view.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.testapplication.R;
import com.example.testapplication.model.networking.FollowingDTO;
import com.example.testapplication.utils.ImageUtils;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 *    팔로잉 목록을 표시하기 위한 리사이클러뷰 어댑터
 */
public class FollowingListAdapter extends RecyclerView.Adapter<FollowingListAdapter.FollowingListViewHolder> {

    ArrayList<FollowingDTO> list;
    ImageUtils utils;
    Context context;

    public FollowingListAdapter(ArrayList<FollowingDTO> list, ImageUtils utils, Context context) {
        this.list = list;
        this.utils = utils;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public FollowingListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.following_list_recylcer_item, parent, false);
        return new FollowingListViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull FollowingListViewHolder holder, int position) {
        holder.setItem(list.get(position));
    }

    // 뷰홀더
    class FollowingListViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView imageView;
        private TextView nickname;


        public FollowingListViewHolder(@NonNull View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.profile_img);
            nickname = itemView.findViewById(R.id.nickname_tv);
        }

        public void setItem(FollowingDTO dto) {
            // 프로필 이미지 삽입
            utils.setImage(imageView, dto.getPhotoUrl(), context);
            // 프로필 닉네임 삽입
            nickname.setText(dto.getNickname());

            // 클릭하면 해당 유저의 피드가 뜨도록 수정
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
