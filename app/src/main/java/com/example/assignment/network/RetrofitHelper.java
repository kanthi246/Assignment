package com.example.assignment.network;

import com.example.assignment.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitHelper {

    public static RetrofitHelper mInstance;
    public NetworkApi mnetworkapi;

    private RetrofitHelper() {
        mInstance = this;
    }

    public static RetrofitHelper getInstance() {
        return mInstance == null ? new RetrofitHelper() : mInstance;
    }

    public NetworkApi getclient() {
        if (mnetworkapi == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            //logging.setLevel(HttpLoggingInterceptor.Level.NONE);
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            // add your other interceptors …

            // add logging as last interceptor
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
            mnetworkapi = retrofit.create(NetworkApi.class);
        }
        return mnetworkapi;
    }
}
