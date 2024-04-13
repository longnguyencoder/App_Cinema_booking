package com.example.moviesappbookingusingapi.Request;

import com.example.moviesappbookingusingapi.Models.Movie;
import com.example.moviesappbookingusingapi.Models.PopularMoviesResponse;
import com.example.moviesappbookingusingapi.Models.TopRatedMoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("movie/popular")
    Call<PopularMoviesResponse> getPopularMovies(@Query("api_key") String api_Key, @Query("page") int page);
    @GET("movie/top_rated")
    Call<TopRatedMoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey, @Query("page") Integer page, @Query("region") String region);

    @GET("movie/{movie_id}")
    Call<Movie> getMovieDetails(@Path("movie_id") Integer movieId, @Query("api_key") String apiKey);
}
