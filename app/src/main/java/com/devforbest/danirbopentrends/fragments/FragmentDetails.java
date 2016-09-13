package com.devforbest.danirbopentrends.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devforbest.danirbopentrends.R;


public class FragmentDetails extends FragmentBase {
    private static FragmentDetails mInstance;

    public static FragmentDetails getInstance() {
        if (mInstance == null) mInstance = new FragmentDetails();
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        return rootView;
    }

}
