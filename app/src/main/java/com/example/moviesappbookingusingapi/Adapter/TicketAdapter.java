package com.example.moviesappbookingusingapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.Models.Ticket;

import java.util.ArrayList;

public class TicketAdapter extends ArrayAdapter<Ticket> {
    private Context context;
    private ArrayList<Ticket> ticketList;

    public TicketAdapter(Context context, ArrayList<Ticket> ticketList) {
        super(context, R.layout.item_ticket, ticketList);
        this.context = context;
        this.ticketList = ticketList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
        }

        // Get current ticket
        Ticket ticket = ticketList.get(position);

        // Set data to views in the layout
        TextView seatInfoTextView = convertView.findViewById(R.id.seatInfoTextView);
        TextView timeTextView = convertView.findViewById(R.id.timeTextView);
        TextView filmTitleTextView = convertView.findViewById(R.id.filmTitleTextView);
        TextView emailTextView = convertView.findViewById(R.id.emailTextView);

        seatInfoTextView.setText(ticket.getSeatInfo());
        timeTextView.setText(ticket.getTime());
        filmTitleTextView.setText(ticket.getFilmTitle());
        emailTextView.setText(ticket.getEmail());

        return convertView;
    }
}
