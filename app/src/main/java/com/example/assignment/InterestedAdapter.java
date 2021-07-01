package com.example.assignment;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignment.models.test_profiles.Profile__1;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class InterestedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Profile__1> interestedList;
    private Boolean viewProfile;
    private Activity mactivity;

    public InterestedAdapter(Activity activity) {
        this.interestedList = new ArrayList<>();
        this.viewProfile = false;
        mactivity = activity;
    }

    public void update(List<Profile__1> stringList, Boolean canSee) {
        this.interestedList.clear();
        this.interestedList.addAll(stringList);
        viewProfile = canSee;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_interested_people, parent, false);
        return new RvViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof RvViewHolder) {
            ((RvViewHolder) holder).bind(interestedList.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return interestedList.size();
    }


    class RvViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textviewName)
        TextView tvName;

        @BindView(R.id.imageViewLikes)
        ImageView imLikes;

        public RvViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(Profile__1 profile, int position) {
            tvName.setText(profile.getFirstName());

            if (viewProfile) {
                Glide.with(mactivity)
                        .load(profile.getAvatar())
                        .into(imLikes);
            } else {
                Glide.with(mactivity)
                        .load(profile.getAvatar())
                        .transform(new BlurTransformation())
                        .into(imLikes);
            }

        }
    }
}
