package com.example.moviesappbookingusingapi.model;

public class Ticket {
    private int ticketID;
    private String seatInfo;
    private String time;
    private String filmTitle;

    public Ticket(String seatInfo, String time, String filmTitle) {
        this.seatInfo = seatInfo;
        this.time = time;
        this.filmTitle = filmTitle;
    }

    public int getTicketID() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID = ticketID;
    }

    public String getSeatInfo() {
        return seatInfo;
    }

    public void setSeatInfo(String seatInfo) {
        this.seatInfo = seatInfo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }
}
