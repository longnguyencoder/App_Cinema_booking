package com.example.moviesappbookingusingapi.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.moviesappbookingusingapi.model.Show;

import java.util.ArrayList;

public class BookingDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "booking.db";
    private static final String TABLE_RESERVATION = "reservation";
    private static final String TABLE_TICKET = "ticket";
    private static final String TABLE_SHOW = "show_film";
    private static final String TABLE_ROOM = "room";

    private SQLiteDatabase db = this.getWritableDatabase();
    public BookingDatabase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TICKET + " (ticket_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_info VARCHAR(512), time VARCHAR(5), title VARCHAR(256));");
        db.execSQL("create table " + TABLE_RESERVATION + " (reservation_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_id VARCHAR(4), film_id INTEGER); ");
        db.execSQL("create table " + TABLE_SHOW + " (film_id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(256), time VARCHAR(5), room_id INTEGER);");
        db.execSQL("create table " + TABLE_ROOM + " (room_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(256));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TICKET + " (ticket_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_info VARCHAR(512), time VARCHAR(5), title VARCHAR(256));");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESERVATION + " (reservation_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_id VARCHAR(4), film_id INTEGER); ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOW + " (film_id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(256), time VARCHAR(5), room_id INTEGER);");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ROOM + " (room_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(256));");

        onCreate(db);
    }

    public boolean insertDatatoReservation(int film_id, String seat_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("seat_id", seat_id);
        contentValues.put("film_id", film_id);

        long result =db.insert(TABLE_RESERVATION, null, contentValues);

        if (result == -1)
            return false;
        return true;
    }

    public boolean insertDatatoShow(String title, String time){
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("time", time);

        long res = db.insert(TABLE_SHOW, null, contentValues);
        if (res == -1)
            return false;
        return true;
    }

    public ArrayList<String> getSeats(int film_id){
        String sql = "SELECT * FROM reservation WHERE film_id LIKE '" + film_id + "';";

        ArrayList<String> seatList = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            @SuppressLint("Range") String seatId = cursor.getString(cursor.getColumnIndex("seat_id"));
            @SuppressLint("Range") int filmId = cursor.getInt(cursor.getColumnIndex("film_id"));

            seatList.add(seatId);
            cursor.moveToNext();
        }
        return seatList;
    }

    public ArrayList<Show> getShows(String title){
        String sql = "SELECT * FROM show_film WHERE title LIKE '" + title + "';";
        ArrayList<Show> shows = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            @SuppressLint("Range") int film_id = cursor.getInt(cursor.getColumnIndex("film_id"));
            @SuppressLint("Range") String time = cursor.getString(cursor.getColumnIndex("time"));

            Show show = new Show(film_id, time);
            shows.add(show);
            cursor.moveToNext();
        }

        return shows;
    }

    public Show getTime(int filmId){
        String sql = "SELECT * FROM show_film WHERE film_id LIKE '" + filmId + "';";

        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();

        @SuppressLint("Range") Show show = new Show(filmId, cursor.getString(cursor.getColumnIndex("time")));
        return show;
    }

    public boolean insertDataToTicket(String seat_info, String time, String title){
        ContentValues contentValues = new ContentValues();
        contentValues.put("seat_info", seat_info);
        contentValues.put("time", time);
        contentValues.put("title", title);

        long res = db.insert(TABLE_TICKET, null, contentValues);
        if (res == -1)
            return false;
        return true;
    }
}
