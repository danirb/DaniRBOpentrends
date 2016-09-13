package com.devforbest.danirbopentrends.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devforbest.danirbopentrends.R;
import com.devforbest.danirbopentrends.adapters.ListRecyclerAdapter;
import com.devforbest.danirbopentrends.network.ResponseModel;
import com.devforbest.danirbopentrends.network.Service;
import com.devforbest.danirbopentrends.network.ServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentList extends FragmentBase {
    private static FragmentList mInstance;
    private View rootView;
    private RecyclerView rv;
    private List<ResponseModel.Result> listaResponse;

    public static FragmentList getInstance() {
        if (mInstance == null) mInstance = new FragmentList();
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.rv_list);
        getCensusAsynk();

        return rootView;
    }

    private void getCensusAsynk() {
        Service client = ServiceGenerator.createService(Service.class);

        Call<ResponseModel> call = client.repoVillage();
        call.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                call.enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        listaResponse = response.body().getResult();
                        Log.d("DRB", response.body().getResult().toString());

                        if (listaResponse != null) {
                            Log.d("DRB", response.body().getResult().toString());
                            rv.setAdapter(new ListRecyclerAdapter(listaResponse, rootView.getContext()));
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {

                    }
                });
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }


        });

    }

}
