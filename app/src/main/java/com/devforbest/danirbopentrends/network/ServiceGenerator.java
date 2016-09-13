package com.devforbest.danirbopentrends.network;


import com.devforbest.danirbopentrends.Constants;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by dani on 17/11/15.
 */
class ServiceGenerator {
//    private static final String API_BASE_URL = "https://randomapi.com/api/?key=LMW0-SW97-ISC4-FF25&id=t60ldyb&results=20";
    private static final OkHttpClient httpClient = new OkHttpClient();
    private static final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient).build();
        return retrofit.create(serviceClass);
    }
}
