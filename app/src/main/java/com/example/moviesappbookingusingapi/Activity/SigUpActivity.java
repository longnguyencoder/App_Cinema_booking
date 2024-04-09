package com.example.moviesappbookingusingapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.databinding.ActivitySigUpBinding;

public class SigUpActivity extends AppCompatActivity {
    ActivitySigUpBinding binding;
    BookingDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivitySigUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = new BookingDatabase(this);
        binding.btnSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.edtEmail.getText().toString();
                String password = binding.edtPassWord.getText().toString();
                String confirmPassword = binding.edtConfirmpassword.getText().toString();

                if (email.equals("") ||password.equals("") ||confirmPassword.equals("") ){
                    Toast.makeText(SigUpActivity.this, "ALL fields are mandatory", Toast.LENGTH_SHORT).show();

                } else{
                    if (password.equals(confirmPassword))
                    {
                    boolean checkUserEmail = db.checkMail(email);
                    if (checkUserEmail ==false){
                        boolean insert = db.inserDataUser(email,password);
                        if (insert== true ){
                            Toast.makeText(SigUpActivity.this, "SinUp Success!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(SigUpActivity.this, "SinUp Fail!", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(SigUpActivity.this, "user alrealy exists, Please Login", Toast.LENGTH_SHORT).show();
                    }
                    }else {
                        Toast.makeText(SigUpActivity.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}