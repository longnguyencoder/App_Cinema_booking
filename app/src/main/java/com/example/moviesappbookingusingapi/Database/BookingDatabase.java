package com.example.moviesappbookingusingapi.Database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookingDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "booking.db";
    private static final String TABLE_RESERVATION = "reservation";
    private static final String TABLE_TICKET = "ticket";
    private static final String TABLE_SHOW = "show_film";
    private static final String TABLE_ROOM = "room";

    private SQLiteDatabase db = this.getWritableDatabase();
    private BookingDatabase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TICKET + " (ticket_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_info VARCHAR(512),date VARCHAR(8), time VARCHAR(5), title VARCHAR(256), " +
                "genres VARCHAR(30), poster VARCHAR(256));");
        db.execSQL("create table " + TABLE_RESERVATION + " (reservation_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_id VARCHAR(4), film_id INTEGER); ");
        db.execSQL("create table " + TABLE_SHOW + " (film_id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(256), time VARCHAR(5), date VARCHAR(8), room_id INTEGER);");
        db.execSQL("create table " + TABLE_ROOM + " (room_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(256));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TICKET + " (ticket_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_info VARCHAR(512), date VARCHAR(8), time VARCHAR(5), title VARCHAR(256), " +
                "genres VARCHAR(30), poster VARCHAR(256));");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESERVATION + " (reservation_id INTEGER PRIMARY KEY AUTOINCREMENT, seat_id VARCHAR(4), film_id INTEGER); ");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOW + " (film_id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR(256), time VARCHAR(5), date VARCHAR(8), room_id INTEGER);");
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
}
