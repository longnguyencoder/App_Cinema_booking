package com.example.moviesappbookingusingapi.Activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviesappbookingusingapi.Adapter.TicketAdapter;
import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.Models.Ticket;

import java.util.ArrayList;

public class AdminActivity extends AppCompatActivity {
    private ListView listView;
    private BookingDatabase bookingDatabase;
    private ArrayList<Ticket> ticketList;
    private TicketAdapter ticketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        listView = findViewById(R.id.listViewTickets);
        bookingDatabase = new BookingDatabase(this);

        // Retrieve list of tickets from the database
        ticketList = bookingDatabase.getAllTickets();

        // Create and set adapter for ListView
        ticketAdapter = new TicketAdapter(this, ticketList);
        listView.setAdapter(ticketAdapter);
    }
}

