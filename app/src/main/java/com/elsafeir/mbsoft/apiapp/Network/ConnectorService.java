package com.elsafeir.mbsoft.apiapp.Network;

import com.elsafeir.mbsoft.apiapp.Model.ResponseModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ConnectorService {

    public String BaseURL = "https://jsonplaceholder.typicode.com/";

    @GET("posts")
    Call<ArrayList<ResponseModel>> getPosts(@Query("fbclid") String fbclid);
}
