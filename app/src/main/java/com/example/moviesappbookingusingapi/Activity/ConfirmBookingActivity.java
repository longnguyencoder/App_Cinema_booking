package com.example.moviesappbookingusingapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.Models.Movie;
import com.example.moviesappbookingusingapi.Models.Show;
import com.example.moviesappbookingusingapi.Models.Ticket;
import com.example.moviesappbookingusingapi.Util.Credentials;
import com.example.moviesappbookingusingapi.databinding.ActivityConfirmBookingBinding;

import java.util.ArrayList;

import retrofit2.Call;

public class ConfirmBookingActivity extends AppCompatActivity {
    ActivityConfirmBookingBinding binding;
    ArrayList<String> seats = new ArrayList<>();
    String totalPrice;
    int filmId;
    int countTicket;
    BookingDatabase db;
    Call<Movie> mMovieComfirmCall;
    Movie movie;
    String allIds = "";
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        movie = (Movie) getIntent().getSerializableExtra("Ticket");
        filmId = getIntent().getIntExtra("FilmId", 0);
        seats = getIntent().getStringArrayListExtra("seatIdList");
        totalPrice = getIntent().getStringExtra("TotalPrice");
        email = getIntent().getStringExtra("email");
        Log.d("email", email);
        db = new BookingDatabase(this);
        countTicket = seats.size();
        setData();
    }

    private void setData(){

        Glide.with(getApplicationContext())
                .load(Credentials.IMAGE_LOADING_BASE_URL_1280 + movie.getPoster_path())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imvConfirm);

        binding.titleConfirmation.setText(movie.getTitle());

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

        Ticket ticket = new Ticket(allIds, show.getTime(), movie.getTitle(), email);

        binding.btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.insertDataToTicket(ticket.getSeatInfo(), ticket.getTime(), ticket.getFilmTitle(), email);

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
                iBackBook.putExtra("FilmIntent", movie);
                startActivity(iBackBook);
            }
        });
    }
}