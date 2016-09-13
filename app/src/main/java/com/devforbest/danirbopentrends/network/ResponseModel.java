package com.devforbest.danirbopentrends.network;

import com.devforbest.danirbopentrends.models.Human;

import java.util.List;


/**
 * Created by dani on 13/09/16.
 */
public class ResponseModel {
    List<Result> result;
    Object info;

    public List<Result> getResult() {
        return result;
    }

    public class Result {
        private Human entity;
        private String seed;

        public Human getEntity() {
            return entity;
        }
    }

}
