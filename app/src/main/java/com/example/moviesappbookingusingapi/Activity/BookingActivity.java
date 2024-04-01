package com.example.moviesappbookingusingapi.Activity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.moviesappbookingusingapi.R;

public class BookingActivity extends AppCompatActivity {
    private int selectedColor = Color.BLACK; // Màu mặc định
    private Button btn_seat1,btn_seat2,btn_seat3,btn_seat4,btn_seat5,btn_seat6,btn_seat7,btn_seat8,btn_seat9,btn_seat10,btn_seat11,btn_seat12,btn_seat13,btn_seat14,btn_seat15,btn_seat16;
    private RadioButton rom1,rom2,rom3,rom4,rom5,rom6,time900,time1100,time1300,time1500,time1700,time2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rom1 = findViewById(R.id.rd_room1);
        rom2 = findViewById(R.id.rd_room2);
        rom3 = findViewById(R.id.rd_room3);
        rom4 = findViewById(R.id.rd_room4);
        rom5 = findViewById(R.id.rd_room5);
        rom6 = findViewById(R.id.rd_room6);

        time900 = findViewById(R.id.rd_time900);
        time1100 = findViewById(R.id.rd_time1100);
        time1300 = findViewById(R.id.rd_time1300);
        time1500 = findViewById(R.id.rd_time1500);
        time1700 = findViewById(R.id.rd_time1700);
        time2000 = findViewById(R.id.rd_time2000);

        btn_seat1 =findViewById(R.id.seat1);
        btn_seat2 =findViewById(R.id.seat2);
        btn_seat3 =findViewById(R.id.seat3);
        btn_seat4 =findViewById(R.id.seat4);
        btn_seat5 =findViewById(R.id.seat5);
        btn_seat6 =findViewById(R.id.seat6);
        btn_seat7 =findViewById(R.id.seat7);
        btn_seat8 =findViewById(R.id.seat8);
        btn_seat9 =findViewById(R.id.seat9);
        btn_seat10 =findViewById(R.id.seat10);
        btn_seat11 =findViewById(R.id.seat11);
        btn_seat12 =findViewById(R.id.seat12);
        btn_seat13 =findViewById(R.id.seat13);
        btn_seat14 =findViewById(R.id.seat14);
        btn_seat15 =findViewById(R.id.seat15);
        btn_seat16 =findViewById(R.id.seat16);
        EvendRoom();
        EvendTime();
        EvendSeat();
    }

    private void EvendSeat() {
        btn_seat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
        btn_seat16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedColor = Color.YELLOW;
            }
        });
    }

    private void EvendTime() {
        time900.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time1100.setChecked(false);
                time1300.setChecked(false);
                time1500.setChecked(false);
                time1700.setChecked(false);
                time2000.setChecked(false);
            }
        });
        time1100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time900.setChecked(false);
                time1300.setChecked(false);
                time1500.setChecked(false);
                time1700.setChecked(false);
                time2000.setChecked(false);
            }
        });
        time1300.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time1100.setChecked(false);
                time900.setChecked(false);
                time1500.setChecked(false);
                time1700.setChecked(false);
                time2000.setChecked(false);
            }
        });
        time1500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time1100.setChecked(false);
                time1300.setChecked(false);
                time900.setChecked(false);
                time1700.setChecked(false);
                time2000.setChecked(false);
            }
        });
        time1700.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time1100.setChecked(false);
                time1300.setChecked(false);
                time1500.setChecked(false);
                time900.setChecked(false);
                time2000.setChecked(false);
            }
        });
        time2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time1100.setChecked(false);
                time1300.setChecked(false);
                time1500.setChecked(false);
                time1700.setChecked(false);
                time900.setChecked(false);
            }
        });
    }

    private void EvendRoom() {
        rom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom2.setChecked(false);
                rom3.setChecked(false);
                rom4.setChecked(false);
                rom5.setChecked(false);
                rom6.setChecked(false);
            }
        });
        rom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom1.setChecked(false);
                rom3.setChecked(false);
                rom4.setChecked(false);
                rom5.setChecked(false);
                rom6.setChecked(false);
            }
        });
        rom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom2.setChecked(false);
                rom1.setChecked(false);
                rom4.setChecked(false);
                rom5.setChecked(false);
                rom6.setChecked(false);
            }
        });
        rom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom2.setChecked(false);
                rom3.setChecked(false);
                rom1.setChecked(false);
                rom5.setChecked(false);
                rom6.setChecked(false);
            }
        });
        rom5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom2.setChecked(false);
                rom3.setChecked(false);
                rom4.setChecked(false);
                rom1.setChecked(false);
                rom6.setChecked(false);
            }
        });
        rom6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rom2.setChecked(false);
                rom3.setChecked(false);
                rom4.setChecked(false);
                rom5.setChecked(false);
                rom1.setChecked(false);
            }
        });
    }

}