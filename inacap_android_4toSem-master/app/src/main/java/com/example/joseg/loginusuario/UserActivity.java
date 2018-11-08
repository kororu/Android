package com.example.joseg.loginusuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    TextView tvUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        //REFERENCES
        tvUser = (TextView) findViewById(R.id.tvUser);

        User userLogin = (User)getIntent().getSerializableExtra("userLogin");
        tvUser.setText("Welcome " + userLogin.fullName());



    }
}
