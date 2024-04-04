package com.example.moviesappbookingusingapi.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.databinding.ActivityBookingBinding;
import com.example.moviesappbookingusingapi.model.Room;
import com.example.moviesappbookingusingapi.model.Seat;

import java.util.ArrayList;

public class BookingActivity extends AppCompatActivity {
    ActivityBookingBinding binding;
    private static final int ROW = 6;
    private static final int COL = 6;
    private ArrayList<Seat> seats;
    private ArrayList<String> seatIds = new ArrayList<>();
    private BookingDatabase bookingDatabase;
    private Room room;
    private static final String TAG = "SeatSelectionActivity";
    int filmId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //
        createTable();
    }

    private void createTable() {
        TableLayout tableLayout = (TableLayout) findViewById(R.id.TableSeats);

        room = new Room(this,tableLayout, binding.price, ROW, COL, bookingDatabase.getSeats(filmId));
    }
}