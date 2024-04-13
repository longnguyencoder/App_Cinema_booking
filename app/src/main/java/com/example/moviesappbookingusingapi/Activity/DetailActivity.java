package com.example.moviesappbookingusingapi.Activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.moviesappbookingusingapi.Models.Movie;
import com.example.moviesappbookingusingapi.Models.MovieBrief;
import com.example.moviesappbookingusingapi.Request.ApiClient;
import com.example.moviesappbookingusingapi.Request.ApiInterface;
import com.example.moviesappbookingusingapi.Util.Credentials;
import com.example.moviesappbookingusingapi.databinding.ActivityDetailBinding;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    ActivityDetailBinding binding;
    private int movieId;

    Movie movie;
    List<MovieBrief> mSimilarList;
    Call<Movie> mMovieDetailsCall;

    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent receivedItent = getIntent();
        movieId = receivedItent.getIntExtra("id", -1);
        email = getIntent().getStringExtra("email");
        Log.d("email_detail", email);
        if (movieId == -1 ) finish();
        addEvents();
        loadActivity();
    }

    private void addEvents() {
        binding.imgBooktiket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBooking = new Intent(DetailActivity.this,BookingActivity.class);
                iBooking.putExtra("movie", movie);
                iBooking.putExtra("email", email);
                startActivity(iBooking);
            }
        });
        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    private void loadActivity() {
        ApiInterface apiInterface = ApiClient.getMovieApi();
        mMovieDetailsCall = apiInterface.getMovieDetails(movieId, Credentials.API_KEY);
        mMovieDetailsCall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(!response.isSuccessful()){
                    mMovieDetailsCall = call.clone();
                    mMovieDetailsCall.enqueue(this);
                    return;
                }

                if (response.body() == null) return;

                Glide.with(getApplicationContext())
                        .load(Credentials.IMAGE_LOADING_BASE_URL_1280 + response.body().getPoster_path())
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .listener(new RequestListener<Drawable>() {
                            @Override
                            public boolean onLoadFailed(@Nullable GlideException e, @Nullable Object model, @NonNull Target<Drawable> target, boolean isFirstResource) {
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(@NonNull Drawable resource, @NonNull Object model, Target<Drawable> target, @NonNull DataSource dataSource, boolean isFirstResource) {
                                return false;
                            }
                        }).into(binding.Poster);
                if (response.body().getTitle() != null)
                    binding.movieNametxt.setText(response.body().getTitle());
                else
                    binding.movieNametxt.setText("");

                if (response.body().getOverview() != null && !response.body().getOverview().trim().isEmpty()){

                    binding.MoviesummeryInfor.setText(response.body().getOverview());
                }else
                    binding.MoviesummeryInfor.setText("");

                setDuration(response.body().getRuntime());
                setYear(response.body().getRelease_date());
                binding.MovieRateTxt.setText(response.body().getVote_average());

                movie = new Movie(response.body().getRuntime(), response.body().getPoster_path(),
                        response.body().getId(), response.body().getTitle());
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable throwable) {

            }
        });


    }
    private void setDuration(Integer runtime){
        String detailsString = "";

        if (runtime != null && runtime != 0) {
            if (runtime < 60) {
                detailsString += runtime + " min(s)";
            } else {
                detailsString += runtime / 60 + " hr " + runtime % 60 + " mins";
            }
        }
        binding.MovieTime.setText(detailsString);
    }
    private void setYear(String releaseDateString) {
        if (releaseDateString != null && !releaseDateString.trim().isEmpty()) {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
            try {
                Date releaseDate = sdf1.parse(releaseDateString);
                binding.movieDate.setText(sdf2.format(releaseDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            binding.movieDate.setText("");
        }
    }

}
