package com.example.moviesappbookingusingapi.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.Domain.FilmItem;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.databinding.ActivityBookingBinding;
import com.example.moviesappbookingusingapi.model.Room;
import com.example.moviesappbookingusingapi.model.Seat;
import com.example.moviesappbookingusingapi.model.Show;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {
    ActivityBookingBinding binding;
    private static final int ROW = 6;
    private static final int COL = 6;
    private ArrayList<Seat> seats;
    private ArrayList<String> seatIds = new ArrayList<>();
    private ArrayList<Show> shows;
    private BookingDatabase bookingDatabase;
    private Room room;
    private static final String TAG = "SeatSelectionActivity";
    Intent intent;
    FilmItem filmItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        shows = new ArrayList<>();

        //getIntent().getIntExtra("id", 0);

        intent = getIntent();
        filmItem = (FilmItem) intent.getSerializableExtra("FilmIntent");

        binding.titleFilm.setText(filmItem.getTitle());

        insertData();
        addEvents();
    }

    private void insertData(){
        bookingDatabase = new BookingDatabase(this);

        bookingDatabase.insertDatatoShow(filmItem.getTitle(), "8:45");
        bookingDatabase.insertDatatoShow(filmItem.getTitle(), "10:30");
        bookingDatabase.insertDatatoShow(filmItem.getTitle(), "13:25");
        bookingDatabase.insertDatatoShow(filmItem.getTitle(), "15:00");
        bookingDatabase.insertDatatoShow(filmItem.getTitle(), "18:20");
        bookingDatabase.insertDatatoShow(filmItem.getTitle(), "20:45");

        shows = bookingDatabase.getShows(filmItem.getTitle());

        String rd_1 = shows.get(0).getTime();
        binding.rdTime1.setText(rd_1);
        String rd_2 = shows.get(1).getTime();
        binding.rdTime2.setText(rd_2);
        String rd_3 = shows.get(2).getTime();
        binding.rdTime3.setText(rd_3);
        String rd_4 = shows.get(3).getTime();
        binding.rdTime4.setText(rd_4);
        String rd_5 = shows.get(4).getTime();
        binding.rdTime5.setText(rd_5);
        String rd_6 = shows.get(5).getTime();
        binding.rdTime6.setText(rd_6);
    }
    private void addEvents() {
        binding.rdgTime.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rd_time_1:
                        removeTable();
                        binding.price.setText("");
                        int filmId_time_1 = shows.get(0).getFilm_id();
                        TableLayout seat_time_1 = (TableLayout) findViewById(R.id.TableSeats);
                        room = new Room(getApplicationContext(),seat_time_1, binding.price, ROW, COL, bookingDatabase.getSeats(filmId_time_1));
                        binding.btnBook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SeatSelect(filmId_time_1);
                            }
                        });
                        break;
                    case R.id.rd_time_2:
                        removeTable();
                        binding.price.setText("");
                        int filmId_time_2 = shows.get(1).getFilm_id();
                        TableLayout seat_time_2 = (TableLayout) findViewById(R.id.TableSeats);
                        room = new Room(getApplicationContext(),seat_time_2, binding.price, ROW, COL, bookingDatabase.getSeats(filmId_time_2));
                        binding.btnBook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SeatSelect(filmId_time_2);
                            }
                        });
                        break;
                    case R.id.rd_time_3:
                        removeTable();
                        binding.price.setText("");
                        int filmId_time_3 = shows.get(2).getFilm_id();
                        TableLayout seat_time_3 = (TableLayout) findViewById(R.id.TableSeats);
                        room = new Room(getApplicationContext(),seat_time_3, binding.price, ROW, COL, bookingDatabase.getSeats(filmId_time_3));
                        binding.btnBook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SeatSelect(filmId_time_3);
                            }
                        });
                        break;
                    case R.id.rd_time_4:
                        removeTable();
                        binding.price.setText("");
                        int filmId_time_4 = shows.get(3).getFilm_id();
                        TableLayout seat_time_4 = (TableLayout) findViewById(R.id.TableSeats);
                        room = new Room(getApplicationContext(),seat_time_4, binding.price, ROW, COL, bookingDatabase.getSeats(filmId_time_4));
                        binding.btnBook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SeatSelect(filmId_time_4);
                            }
                        });
                        break;
                    case R.id.rd_time_5:
                        removeTable();
                        binding.price.setText("");
                        int filmId_time_5 = shows.get(4).getFilm_id();
                        TableLayout seat_time_5 = (TableLayout) findViewById(R.id.TableSeats);
                        room = new Room(getApplicationContext(),seat_time_5, binding.price, ROW, COL, bookingDatabase.getSeats(filmId_time_5));
                        binding.btnBook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SeatSelect(filmId_time_5);
                            }
                        });
                        break;
                    case R.id.rd_time_6:
                        removeTable();
                        binding.price.setText("");
                        int filmId_time_6 = shows.get(5).getFilm_id();
                        TableLayout seat_time_6 = (TableLayout) findViewById(R.id.TableSeats);
                        room = new Room(getApplicationContext(),seat_time_6, binding.price, ROW, COL, bookingDatabase.getSeats(filmId_time_6));
                        binding.btnBook.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SeatSelect(filmId_time_6);
                            }
                        });
                        break;
                }
            }
        });
    }


   /* private void createTable() {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.TableSeats);
        room = new Room(this,tableLayout, binding.price, ROW, COL, bookingDatabase.getSeats(filmId));
    }*/

    private void removeTable() {
        TableLayout tableLayout = binding.TableSeats;
        int count = tableLayout.getChildCount();

        for (int i = count - 1; i >= 0; i--) {
            View child = tableLayout.getChildAt(i);

            if (child instanceof TableRow) {
                tableLayout.removeViewAt(i);
            }
        }
    }

    private void SeatSelect(int filmId){
        seats = room.getSeats();

        for (int i = 0; i < seats.size(); i++){
            seatIds.add(seats.get(i).getSeatID());

            Log.d("seats", seatIds.get(i) +"");
        }

        if (seats.size() == 0)
            Toast.makeText(BookingActivity.this, "No seat selected", Toast.LENGTH_SHORT).show();
        else {
            Intent iConfirm = new Intent(BookingActivity.this, ConfirmBookingActivity.class);
            iConfirm.putExtra("Ticket", filmItem);
            iConfirm.putStringArrayListExtra("seatIdList", seatIds);
            iConfirm.putExtra("TotalPrice", Double.toString(room.calculate(seats)));
            iConfirm.putExtra("FilmId", filmId);
            startActivity(iConfirm);
        }
    }

}