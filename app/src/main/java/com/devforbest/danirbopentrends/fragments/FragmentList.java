package com.devforbest.danirbopentrends.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devforbest.danirbopentrends.R;
import com.devforbest.danirbopentrends.network.GetList;


public class FragmentList extends FragmentBase {
    private static FragmentList mInstance;
    private View rootView;
    private GetList g;
    private RecyclerView rv;

    public static FragmentList getInstance() {
        if (mInstance == null) mInstance = new FragmentList();
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_list, container, false);

        rv = (RecyclerView) rootView.findViewById(R.id.rv_list);

        setRecycler();
        getCensusAsynk();
        return rootView;
    }

    private void getCensusAsynk() {
        g = new GetList(rootView.getContext(), rv);
        g.execute();
    }

    private void setRecycler() {
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_list);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));
    }

}
