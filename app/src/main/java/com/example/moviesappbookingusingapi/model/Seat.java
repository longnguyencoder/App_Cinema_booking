package com.example.moviesappbookingusingapi.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;

public class Seat extends AppCompatButton {
    private String ID; //hashcode //row col string //

    private int roomID;
    private String seatID;
    private int rowNum;
    private int colNum;
    private boolean isSelected;
    private boolean isBooked = false;
    private final double price = 10.00;
    public Seat(@NonNull Context context) {
        super(context);
    }
}
