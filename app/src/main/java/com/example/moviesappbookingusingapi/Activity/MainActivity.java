package com.example.moviesappbookingusingapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.moviesappbookingusingapi.Fragment.HomeFragment;
import com.example.moviesappbookingusingapi.Fragment.ProfileFragment;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
//    private FilmListAdapter adapterTopRate,adapterPopular;
    ActivityMainBinding binding;
    Intent intent;
//    private List<MovieBrief> topRateList;
//    private List<MovieBrief> popularList;
//    Call<PopularMoviesResponse> popularMoviesResponseCall;
//    Call<TopRatedMoviesResponse> topRatedMoviesResponseCall;

    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        email = getIntent().getStringExtra("email");

        Log.d("test", email);

        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();

//                popularList = new ArrayList<>();
//        topRateList = new ArrayList<>();
//        email = getIntent().getStringExtra("email");
//
//        adapterPopular = new FilmListAdapter(popularList,MainActivity.this);
//        adapterTopRate = new FilmListAdapter(topRateList,MainActivity.this);
//        binding.recViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//        binding.recViewTopRate.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
//
//        binding.recViewPopular.setAdapter(adapterPopular);
//        binding.recViewTopRate.setAdapter(adapterTopRate);
//
//        Log.d("test", popularList + "");
//        //initView();
//        popularMovie();
//        topRateMovie();
        EventsBottomNav();
    }

    private void EventsBottomNav() {
    binding.bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.mnHome:
                    if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("HomeFragment")) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

                    }
                    break;
                case R.id.mnProfile:
                    if (!getSupportFragmentManager().findFragmentById(R.id.fragment_container).getClass().getSimpleName().equals("ProfileFragment")) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();

                    }
            }
            return true;
        }
    });
    }

//    private void popularMovie() {
//        ApiInterface apiInterface = ApiClient.getMovieApi();
//        popularMoviesResponseCall= apiInterface.getPopularMovies(Credentials.API_KEY,1);
//        popularMoviesResponseCall.enqueue(new Callback<PopularMoviesResponse>() {
//            @Override
//            public void onResponse(@NonNull Call<PopularMoviesResponse> call, @NonNull Response<PopularMoviesResponse> response) {
//                if(!response.isSuccessful()){
//                    popularMoviesResponseCall = call.clone();
//                    popularMoviesResponseCall.enqueue(this);
//                    return;
//                }
//
//                if(response.body() == null) return;
//                if (response.body().getResults() == null) return;
//
//                for (MovieBrief movieBrief : response.body().getResults()){
//                    if (movieBrief != null && movieBrief.getBackdropPath() != null)
//                        popularList.add(movieBrief);
//                }
//                adapterPopular.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<PopularMoviesResponse> call, @NonNull Throwable throwable) {
//
//            }
//        });
//    }
//    private void topRateMovie() {
//        ApiInterface apiService = ApiClient.getMovieApi();
//        topRatedMoviesResponseCall = apiService.getTopRatedMovies(Credentials.API_KEY, 1, "US");
//        topRatedMoviesResponseCall.enqueue(new Callback<TopRatedMoviesResponse>() {
//            @Override
//            public void onResponse(Call<TopRatedMoviesResponse> call, Response<TopRatedMoviesResponse> response) {
//                if (!response.isSuccessful()){
//                    topRatedMoviesResponseCall = call.clone();
//                    topRatedMoviesResponseCall.enqueue(this);
//                    return;
//                }
//
//                if (response.body() == null) return;
//                if (response.body().getResults() == null) return;
//
//                for(MovieBrief movieBrief : response.body().getResults()){
//                    if (movieBrief != null && movieBrief.getPosterPath() != null)
//                        topRateList.add(movieBrief);
//                }
//
//                adapterTopRate.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onFailure(Call<TopRatedMoviesResponse> call, Throwable t) {
//
//            }
//        });
//    }

}