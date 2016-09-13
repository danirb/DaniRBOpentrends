package com.devforbest.danirbopentrends.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devforbest.danirbopentrends.R;


public class FragmentList extends FragmentBase {
    private static FragmentList mInstance;

    public static FragmentList getInstance() {
        if (mInstance == null) mInstance = new FragmentList();
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        return rootView;
    }

}
