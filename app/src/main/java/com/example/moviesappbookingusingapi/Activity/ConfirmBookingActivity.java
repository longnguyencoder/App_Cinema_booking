package com.example.moviesappbookingusingapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.Domain.FilmItem;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.databinding.ActivityConfirmBookingBinding;
import com.example.moviesappbookingusingapi.model.Show;
import com.example.moviesappbookingusingapi.model.Ticket;

import java.util.ArrayList;

public class ConfirmBookingActivity extends AppCompatActivity {
    ActivityConfirmBookingBinding binding;
    ArrayList<String> seats = new ArrayList<>();
    String totalPrice;
    int filmId;
    int countTicket;
    BookingDatabase db;
    FilmItem filmItem;
    String allIds = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        filmItem = (FilmItem) getIntent().getSerializableExtra("Ticket");
        filmId = getIntent().getIntExtra("FilmId", 0);
        seats = getIntent().getStringArrayListExtra("seatIdList");
        totalPrice = getIntent().getStringExtra("TotalPrice");

        db = new BookingDatabase(this);
        countTicket = seats.size();

        setData();

    }

    private void setData(){
        Glide.with(getApplicationContext())
                .load(filmItem.getPoster())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imvConfirm);

        binding.titleConfirmation.setText(filmItem.getTitle());

        Show show = db.getTime(filmId);
        binding.dateConfirmation.setText("Time: " + show.getTime());

        for (String id : seats){
            String res = id;
            String[] stringArr = res.split(",");
            int[] intArr = new int[stringArr.length];
            for (int i = 0; i < stringArr.length; i++){
                String number = stringArr[i];
                intArr[i] = Integer.parseInt(number);
            }

            allIds += "Row: " + (intArr[0] + 1) + " Num: " + (intArr[1] + 1) + "\n";
        }

        binding.seatNumberConfirm.setText(allIds);
        binding.totalTicketConfirm.setText(countTicket + "");
        binding.totalPriceConfirm.setText(totalPrice);

        Ticket ticket = new Ticket(allIds, show.getTime(), filmItem.getTitle());

        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertDataToTicket(ticket.getSeatInfo(), ticket.getTime(), ticket.getFilmTitle());

                for (int i = 0; i < seats.size(); i++){
                    db.insertDatatoReservation(filmId, seats.get(i));
                }
                Toast.makeText(ConfirmBookingActivity.this,"Success", Toast.LENGTH_SHORT).show();
                Intent iThank = new Intent(ConfirmBookingActivity.this, ThankActivity.class);
                startActivity(iThank);
            }
        });

        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iBackBook = new Intent(ConfirmBookingActivity.this, BookingActivity.class);
                iBackBook.putExtra("FilmIntent", filmItem);
                startActivity(iBackBook);
            }
        });
    }
}