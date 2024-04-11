package com.example.moviesappbookingusingapi.model.Search;

public class SearchArrayObject {
    String title = "";
    String poster = "";
    String id = "";

    public SearchArrayObject(String title, String poster, String id) {
        this.title = title;
        this.poster = poster;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster() {
        return poster;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setId(String id) {
        this.id = id;
    }
}
