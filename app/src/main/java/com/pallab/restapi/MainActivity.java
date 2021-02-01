package com.pallab.restapi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvView = findViewById(R.id.rvMain);
        rvView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        RetrofitInterface retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);
        Call<List<PhotoModel>> listCall = retrofitInstance.getAllPhotos();
        listCall.enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                parseData(response.body());

            }

            @Override
            public void onFailure(Call<List<PhotoModel>> call, Throwable t) {

            }
        });

    }

    private void parseData(List<PhotoModel> body) {
        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(body);
        rvView.setAdapter(recyclerviewAdapter);

    }

}