package com.example.moviesappbookingusingapi.Activity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.databinding.ActivityConfirmBookingBinding;

public class ConfirmBookingActivity extends AppCompatActivity {
    ActivityConfirmBookingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfirmBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}