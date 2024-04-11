package com.example.moviesappbookingusingapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.moviesappbookingusingapi.Database.BookingDatabase;
import com.example.moviesappbookingusingapi.databinding.ActivityLoginBinding;
import com.example.moviesappbookingusingapi.model.User;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    BookingDatabase db;
    ArrayList<User> users;
    int user_Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding= ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db= new BookingDatabase(this);
        users = new ArrayList<>();

        addEvents();
    }

    private void addEvents() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.edtUserName.getText().toString();
                String password = binding.edtPassword.getText().toString();
                if (email.equals("") ||password.equals("")) {
                    Toast.makeText(LoginActivity.this, "ALL fields are mandatory", Toast.LENGTH_SHORT).show();
                }else{
                        boolean check_accuracy =db.checkEmailPassword(email,password);

                        if (check_accuracy==true ){

                            //users = db.getUserId(email);
                            //User_Id = users.get(0).getUser_id();

                            Log.d("test", user_Id +"");

                            Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);


                        }else {
                            Toast.makeText(LoginActivity.this, "Accuracy Fail", Toast.LENGTH_SHORT).show();
                        }
                }

            }
        });
        binding.txtSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SigUpActivity.class);

                startActivity(intent);
            }
        });
    }


}
