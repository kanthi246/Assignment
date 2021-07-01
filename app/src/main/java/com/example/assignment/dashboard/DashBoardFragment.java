package com.example.assignment.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.assignment.InterestedAdapter;
import com.example.assignment.R;
import com.example.assignment.models.test_profiles.GetProfileListResponse;
import com.example.assignment.models.test_profiles.Likes;
import com.example.assignment.models.test_profiles.Profile;
import com.example.assignment.network.NetworkApi;
import com.example.assignment.network.RetrofitHelper;
import com.example.assignment.utils.AppPreferences;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardFragment extends Fragment {

    @BindView(R.id.imageViewBanner)
    ImageView imBanner;

    @BindView(R.id.textviewName_Age)
    TextView tv_name_age;

    @BindView(R.id.layoutNote)
    NestedScrollView llNote;

    @BindView(R.id.layoutInterested)
    ConstraintLayout llInterested;

    @BindView(R.id.recyclerViewLikes)
    RecyclerView rvLikes;

    @BindView(R.id.progressBar2)
    ProgressBar loader;

    private InterestedAdapter interestedAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Setting Recycler view to adapter
        interestedAdapter = new InterestedAdapter(requireActivity());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(requireActivity(), 2);
        rvLikes.setLayoutManager(gridLayoutManager);
        rvLikes.setAdapter(interestedAdapter);
        networkGetProfiles();
    }

    private void networkGetProfiles() {
        loader.setVisibility(View.VISIBLE);
        llNote.setVisibility(View.GONE);
        NetworkApi service1 = RetrofitHelper.getInstance().getclient();
        Call<GetProfileListResponse> call1 = service1.getProfileList(AppPreferences.getAccessToken(requireActivity()));
        call1.enqueue(new Callback<GetProfileListResponse>() {
            @Override
            public void onResponse(Call<GetProfileListResponse> call, Response<GetProfileListResponse> response) {
                loader.setVisibility(View.GONE);
                llNote.setVisibility(View.VISIBLE);
                if (response.code() == 200 && response.body() != null) {
                    Likes like = response.body().getLikes();
                    List<Profile> profile = response.body().getInvites().getProfiles();

                    Glide.with(requireActivity())
                            .load(profile.get(0).getPhotos().get(0).getPhoto())
                            .into(imBanner);
                    String name_age = profile.get(0).getGeneralInformation().getFirstName() + ", " + profile.get(0).getGeneralInformation().getAge();
                    tv_name_age.setText(name_age);
                    interestedAdapter.update(like.getProfiles(), like.getCanSeeProfile());
                    if (like.getCanSeeProfile()) {
                        llInterested.setVisibility(View.GONE);
                    } else {
                        llInterested.setVisibility(View.VISIBLE);
                    }
                } else {
                    Toast.makeText(getActivity(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetProfileListResponse> call, Throwable t) {
                t.printStackTrace();
                loader.setVisibility(View.GONE);
                llNote.setVisibility(View.GONE);
                Toast.makeText(getActivity(), getActivity().getString(R.string.something_wrong), Toast.LENGTH_SHORT).show();
            }
        });
    }

}