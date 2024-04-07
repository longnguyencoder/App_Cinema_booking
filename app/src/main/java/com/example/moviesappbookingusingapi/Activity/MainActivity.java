package com.example.moviesappbookingusingapi.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.moviesappbookingusingapi.Adapter.FilmListAdapter;
import com.example.moviesappbookingusingapi.Domain.FilmItem;
import com.example.moviesappbookingusingapi.R;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterNewMovies,adaterUpcomming;
    private  RecyclerView recyclerViewNewMovies,recyclerViewUpcomming;
    private RequestQueue requestQueue;
    private  StringRequest stringRequest,stringRequest2;
    private ProgressBar loading, loading2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initView();
        sendRequest();
        sendRequest2();
    }

    private void sendRequest() {
        requestQueue = Volley.newRequestQueue(this);
        loading.setVisibility(View.VISIBLE);
        stringRequest = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies?page=1", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                loading.setVisibility(View.GONE);
                FilmItem items = gson.fromJson(s,FilmItem.class);
                adapterNewMovies = new FilmListAdapter(items);
                recyclerViewNewMovies.setAdapter(adapterNewMovies);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i("uilover","sendRequest2: "+volleyError.toString());
                loading.setVisibility(View.GONE);
            }
        });
        requestQueue.add(stringRequest);

    }
    private void sendRequest2() {
        requestQueue = Volley.newRequestQueue(this);
        loading2.setVisibility(View.VISIBLE);
        stringRequest2 = new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies?page=3", new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                loading2.setVisibility(View.GONE);
                FilmItem items = gson.fromJson(s,FilmItem.class);
                adaterUpcomming = new FilmListAdapter(items);
                recyclerViewUpcomming.setAdapter(adaterUpcomming);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                loading2.setVisibility(View.GONE);
            }
        });
        requestQueue.add(stringRequest2);
    }

    private void initView() {
        recyclerViewNewMovies = findViewById(R.id.View1);
        recyclerViewNewMovies.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewUpcomming =findViewById(R.id.View2);
        recyclerViewUpcomming.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        loading =findViewById(R.id.loading);
        loading2 =findViewById(R.id.loading1);
    }
}