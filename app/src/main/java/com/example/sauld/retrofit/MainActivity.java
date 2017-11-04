package com.example.sauld.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://vinrosa.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        itemsService itemsService = retrofit.create(com.example.sauld.retrofit.itemsService.class);

      //  final ArrayList<ItemsModelo> itemsModelos = new ArrayList<>();


        itemsService.getItems().enqueue(new Callback<List<ItemsModelo>>() {
            @Override
            public void onResponse(Call<List<ItemsModelo>> call, Response<List<ItemsModelo>> response) {
                Log.d("Mensaje: ", response.body().toString());
              //  itemsModelos.add((response.body()));
                recyclerView = (RecyclerView) findViewById(R.id.recycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(new MyAdapter(response.body(), getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<ItemsModelo>> call, Throwable t) {

            }
        });

        itemsService.postForm("Hola").enqueue(new Callback<FormResponse>() {
            @Override
            public void onResponse(Call<FormResponse> call, Response<FormResponse> response) {
                Log.d("R", "msg " + response.body());
            }

            @Override
            public void onFailure(Call<FormResponse> call, Throwable t) {

            }
        });
    }
}
