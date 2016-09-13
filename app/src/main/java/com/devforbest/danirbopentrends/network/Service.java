package com.devforbest.danirbopentrends.network;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by dani on 14/12/15.
 */
interface Service {

    @GET("")
    Call<ResponseModel> repoVillage();



}

