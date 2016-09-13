package com.devforbest.danirbopentrends.network;

import com.devforbest.danirbopentrends.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by dani on 17/11/15.
 */
public class ServiceGenerator {
    public static HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Constants.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        Retrofit retrofit = builder.client(httpClient.addInterceptor(logging).build()).build();
        return retrofit.create(serviceClass);
    }
}
