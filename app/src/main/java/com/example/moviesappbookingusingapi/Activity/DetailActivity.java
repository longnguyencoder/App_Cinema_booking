package com.example.moviesappbookingusingapi.Activity;

import static android.view.View.GONE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.moviesappbookingusingapi.Adapter.ImageListAdapter;
import com.example.moviesappbookingusingapi.Domain.FilmItem;
import com.example.moviesappbookingusingapi.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.Gson;

public class DetailActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    private StringRequest stringRequest;
    private ProgressBar progressBar;
    private TextView titletxt,MovieRateTxt,MovieTime,movieDate,Summery,MoviesummeryInfor,MovieActorInfor;
    private NestedScrollView scrollView;
    private int idFilm;
    private ShapeableImageView pic1;
    private ImageView pic2,backImg,bookingImg;
    private RecyclerView.Adapter adapterImgList;
    private  RecyclerView recyclerView;
    FilmItem filmItemIntent, items;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        idFilm = getIntent().getIntExtra("id",0);
        email = getIntent().getStringExtra("email");
        Log.d("email_detail", email);

        initView();

        sendRequest();
    }

    private void sendRequest() {
        requestQueue = Volley.newRequestQueue(this);

        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);
        stringRequest= new StringRequest(Request.Method.GET, "https://moviesapi.ir/api/v1/movies/" + idFilm, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                progressBar.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);

                    items = gson.fromJson(s,FilmItem.class);

                Glide.with(DetailActivity.this)
                        .load(items.getPoster())
                        .into(pic1);

                Glide.with(DetailActivity.this)
                        .load(items.getPoster())
                        .into(pic2);

                titletxt.setText(items.getTitle());
                MovieRateTxt.setText(items.getRated());
                MovieTime.setText(items.getRuntime());
                movieDate.setText(items.getReleased());
                MoviesummeryInfor.setText(items.getPlot());
                MovieActorInfor.setText(items.getActors());
                if(items.getImages()!=null){
                    adapterImgList= new ImageListAdapter(items.getImages());
                    recyclerView.setAdapter(adapterImgList);
                }
                filmItemIntent = items;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

                progressBar.setVisibility(GONE);
                Log.i("uilover","onErrorResponse"+volleyError.toString());
            }
        });


        requestQueue.add(stringRequest);
    }

    private void initView() {
        titletxt =findViewById(R.id.movieNametxt);
        progressBar =findViewById(R.id.detailLoggin);
        scrollView =findViewById(R.id.scrollView4);
        pic1 = findViewById(R.id.Poster);
        pic2 =findViewById(R.id.poster_Biglmg);
        MovieRateTxt= findViewById(R.id.MovieRateTxt);
        MovieTime = findViewById(R.id.MovieTime);
        movieDate = findViewById(R.id.movieDate);
        MoviesummeryInfor = findViewById(R.id.MoviesummeryInfor);
        MovieActorInfor = findViewById(R.id.MovieActorInfor);
        backImg = findViewById(R.id.img_back);
        bookingImg = findViewById(R.id.img_booktiket);
        recyclerView = findViewById(R.id.imageRecyclerViewdetail);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        bookingImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailActivity.this,BookingActivity.class);
                intent.putExtra("FilmIntent", filmItemIntent);
                intent.putExtra("email", email);
                startActivity(intent);
            }
        });
    }
}