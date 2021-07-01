package com.example.assignment.network;

import com.example.assignment.models.PostMobileNumberRequest;
import com.example.assignment.models.SendOtp;
import com.example.assignment.models.VerifyOtp;
import com.example.assignment.models.test_profiles.GetProfileListResponse;
import com.example.assignment.utils.Constants;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface NetworkApi {

    @Headers({"Content-type:application/json",
            "Cookie:__cfduid=df9b865983bd04a5de2cf5017994bbbc71618565720"})
    @POST(Constants.URL_USER_SEND_OTP)
    Call<SendOtp> postSendOtp(@Body PostMobileNumberRequest request);

    @Headers({"Content-type:application/json",
            "Cookie:__cfduid=df9b865983bd04a5de2cf5017994bbbc71618565720"})
    @POST(Constants.URL_USER_VERIFY_OTP)
    Call<VerifyOtp> postVerifyOtp(@Body PostMobileNumberRequest request);

    @Headers({"Content-type:application/json",
            "Cookie:__cfduid=df9b865983bd04a5de2cf5017994bbbc71618565720"})
    @GET(Constants.URL_GET_PROFILE_LIST)
    Call<GetProfileListResponse> getProfileList(@Header("Authorization") String auth);


}


