package com.elsafeir.mbsoft.apiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.elsafeir.mbsoft.apiapp.Adapter.PostAdapter;
import com.elsafeir.mbsoft.apiapp.Model.ResponseModel;
import com.elsafeir.mbsoft.apiapp.Network.ConnectorService;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ResponseModel> responseModels;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPostByFbclid();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        responseModels = new ArrayList<>();
        postAdapter = new PostAdapter(responseModels);
        recyclerView.setAdapter(postAdapter);

    }

    public void getPostByFbclid(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConnectorService.BaseURL)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        ConnectorService connectorService = retrofit.create(ConnectorService.class);

        connectorService.getPosts("1").enqueue(new Callback<ArrayList<ResponseModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ResponseModel>> call, Response<ArrayList<ResponseModel>> response) {
                Log.d("TTT", "onResponse: "+call.request().url());
                if (response.isSuccessful()){
                    responseModels.addAll(response.body());
                    Log.d("TTT", "onResponse: "+response.body().get(1).getTitle());
                    postAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ArrayList<ResponseModel>> call, Throwable t) {

            }
        });

    }
}
