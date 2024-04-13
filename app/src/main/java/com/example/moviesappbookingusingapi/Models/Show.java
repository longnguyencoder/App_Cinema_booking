package com.example.moviesappbookingusingapi.Models;

public class Show {
    private int film_id;
    private String time;
    private int room_id;

    public Show(int film_id, String time) {
        this.film_id = film_id;
        this.time = time;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}
