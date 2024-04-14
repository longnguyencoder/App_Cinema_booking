package com.example.moviesappbookingusingapi.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.moviesappbookingusingapi.Adapter.TicketAdapter;
import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.Models.Ticket;
import com.example.moviesappbookingusingapi.R;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    private BookingDatabase bookingDatabase;
    private ListView listViewTickets;
    private Button btnShowHistory;
    private TextView tvnameEmail;





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profile_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize views
        listViewTickets = view.findViewById(R.id.lvHistory);
        btnShowHistory = view.findViewById(R.id.btn_history);
        tvnameEmail = view.findViewById(R.id.nameEmail);

        // Retrieve the current user's email from SharedPreferences
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        String currentUserEmail = sharedPreferences.getString("user_email", "");

        // Set the user's email as the name (temporary implementation)
        tvnameEmail.setText(  currentUserEmail);
        // Initialize database
        bookingDatabase = new BookingDatabase(getActivity());

        // Set onClickListener for the button
        btnShowHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the current user's email from SharedPreferences
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
                String currentUserEmail = sharedPreferences.getString("user_email", "");

                // Show the list of tickets for the current user
                showTickets(currentUserEmail);
            }

            private void showTickets(String currentUserEmail) {
                // Retrieve tickets for the current user
                ArrayList<Ticket> userTickets = bookingDatabase.getProfileTickets(currentUserEmail);

                // Populate ListView with user's tickets using TicketAdapter
                TicketAdapter adapter = new TicketAdapter(getActivity(), userTickets);
                listViewTickets.setAdapter(adapter);
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
