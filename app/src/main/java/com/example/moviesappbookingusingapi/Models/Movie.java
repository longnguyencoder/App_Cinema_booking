package com.example.moviesappbookingusingapi.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("runtime")
    private Integer runtime;
    @SerializedName("poster_path")
    private String poster_path;
    @SerializedName("overview")
    private String overview;
    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String title;
    @SerializedName("release_date")
    private String release_date;

    @SerializedName("vote_average")
    private String vote_average;

    public Movie(Integer runtime, String poster_path, String overview, Integer id, String title, String release_date, String vote_average) {
        this.runtime = runtime;
        this.poster_path = poster_path;
        this.overview = overview;
        this.id = id;
        this.title = title;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }

    public Movie(Integer runtime, String poster_path, Integer id, String title) {
        this.runtime = runtime;
        this.poster_path = poster_path;
        this.id = id;
        this.title = title;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
