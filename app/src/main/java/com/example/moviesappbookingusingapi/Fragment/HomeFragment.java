package com.example.moviesappbookingusingapi.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesappbookingusingapi.Adapter.FilmListAdapter;
import com.example.moviesappbookingusingapi.Models.MovieBrief;
import com.example.moviesappbookingusingapi.Models.PopularMoviesResponse;
import com.example.moviesappbookingusingapi.Models.TopRatedMoviesResponse;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.Request.ApiClient;
import com.example.moviesappbookingusingapi.Request.ApiInterface;
import com.example.moviesappbookingusingapi.Util.Credentials;
import com.example.moviesappbookingusingapi.databinding.HomeFragmentBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private FilmListAdapter adapterTopRate,adapterPopular;
    HomeFragmentBinding binding;
    private List<MovieBrief> topRateList;
    private List<MovieBrief> popularList;
    Call<PopularMoviesResponse> popularMoviesResponseCall;
    Call<TopRatedMoviesResponse> topRatedMoviesResponseCall;
    RecyclerView recViewPopular;
    RecyclerView recViewTopRate;
    Context context;
    String email;
    Intent intent;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        email = this.getArguments().getString("email");
//
//        Log.d("test", email + " ");
        return inflater.inflate(R.layout.home_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        popularList = new ArrayList<>();
        topRateList = new ArrayList<>();



        recViewPopular = view.findViewById(R.id.recViewPopular);
        recViewTopRate = view.findViewById(R.id.recViewTopRate);

        adapterPopular = new FilmListAdapter(popularList, getContext());
        adapterTopRate = new FilmListAdapter(topRateList,getContext());
        recViewPopular.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recViewTopRate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));

        recViewPopular.setAdapter(adapterPopular);
        recViewTopRate.setAdapter(adapterTopRate);

        Log.d("test", popularList + "");
        //initView();
        popularMovie();
        topRateMovie();

    }


    private void popularMovie() {
        ApiInterface apiInterface = ApiClient.getMovieApi();
        popularMoviesResponseCall= apiInterface.getPopularMovies(Credentials.API_KEY,1);
        popularMoviesResponseCall.enqueue(new Callback<PopularMoviesResponse>() {
            @Override
            public void onResponse(@NonNull Call<PopularMoviesResponse> call, @NonNull Response<PopularMoviesResponse> response) {
                if(!response.isSuccessful()){
                    popularMoviesResponseCall = call.clone();
                    popularMoviesResponseCall.enqueue(this);
                    return;
                }

                if(response.body() == null) return;
                if (response.body().getResults() == null) return;

                for (MovieBrief movieBrief : response.body().getResults()){
                    if (movieBrief != null && movieBrief.getBackdropPath() != null)
                        popularList.add(movieBrief);
                }
                adapterPopular.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<PopularMoviesResponse> call, @NonNull Throwable throwable) {

            }
        });
    }
    private void topRateMovie() {
        ApiInterface apiService = ApiClient.getMovieApi();
        topRatedMoviesResponseCall = apiService.getTopRatedMovies(Credentials.API_KEY, 1, "US");
        topRatedMoviesResponseCall.enqueue(new Callback<TopRatedMoviesResponse>() {
            @Override
            public void onResponse(Call<TopRatedMoviesResponse> call, Response<TopRatedMoviesResponse> response) {
                if (!response.isSuccessful()){
                    topRatedMoviesResponseCall = call.clone();
                    topRatedMoviesResponseCall.enqueue(this);
                    return;
                }

                if (response.body() == null) return;
                if (response.body().getResults() == null) return;

                for(MovieBrief movieBrief : response.body().getResults()){
                    if (movieBrief != null && movieBrief.getPosterPath() != null)
                        topRateList.add(movieBrief);
                }

                adapterTopRate.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TopRatedMoviesResponse> call, Throwable t) {

            }
        });
    }
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
