package com.example.moviesappbookingusingapi.Response;

import com.example.moviesappbookingusingapi.Models.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearchResponse {
    @SerializedName("total_results")
    @Expose
    private  int total_count;
    @SerializedName("results")
    @Expose
    private List<Movie> movie;
    public  int getTotal_count(){
        return total_count;
    }
    public List<Movie> getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movie=" + movie +
                '}';
    }
}
