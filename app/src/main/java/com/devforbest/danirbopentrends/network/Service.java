package com.devforbest.danirbopentrends.network;


import retrofit2.Call;
import retrofit2.http.GET;

;

/**
 * Created by dani on 14/12/15.
 */
public interface Service {

    @GET("")
    Call<ResponseModel> repoVillage();


}

