package com.example.moviesappbookingusingapi.Response;

import com.example.moviesappbookingusingapi.Models.Movie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("results")
    @Expose
    private Movie movie;
    public Movie getMovie(){
        return movie;
    }
}
