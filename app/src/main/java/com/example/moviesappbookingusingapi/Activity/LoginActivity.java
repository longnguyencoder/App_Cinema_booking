package com.example.moviesappbookingusingapi.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.moviesappbookingusingapi.R;

public class LoginActivity extends AppCompatActivity {
    EditText edt_usname,edt_password;
    Button btn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        InnitView();

    }

    private void InnitView() {
        edt_usname= findViewById(R.id.edt_UserName);
        edt_password= findViewById(R.id.edt_Password);
        btn_Login= findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edt_usname.getText().toString().isEmpty()|| edt_password.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "please fill your user and password",Toast.LENGTH_SHORT).show();
                }else if(edt_usname.getText().toString().equals("test")|| edt_password.getText().toString().equals("test")){
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}