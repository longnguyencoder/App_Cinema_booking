package com.example.moviesappbookingusingapi.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.moviesappbookingusingapi.Adapter.TicketAdapter;
import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.Models.Ticket;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.databinding.ProfileFragmentBinding;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    ProfileFragmentBinding binding;
    private ArrayList<Ticket> ticketList;
    private TicketAdapter ticketAdapter;
    private BookingDatabase db;
    ListView lvHistory;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ticketAdapter = new TicketAdapter(getContext(),ticketList);
        lvHistory = view.findViewById(R.id.lvHistory);
        ticketList= new ArrayList<>();
        db =new BookingDatabase(getContext());
        ticketList = new ArrayList<>();
        ticketAdapter = new TicketAdapter(getContext(), ticketList);
        lvHistory.setAdapter(ticketAdapter);
        addEvents();


    }

    private void addEvents() {
        binding.btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ticket ticket = new Ticket("Seat Info", "Time", "Film Title", "Email");
                ticket.setSeatInfo("Seat Info");
                ticket.setTime("Time");
                ticket.setFilmTitle("Film Title");
                ticket.setEmail("Email");

                ticketList.add(ticket);
                ticketAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
