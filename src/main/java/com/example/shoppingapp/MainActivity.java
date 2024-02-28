package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnLoginPage, btnRegisterPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLoginPage=findViewById(R.id.btnLoginPage);
        btnRegisterPage=findViewById(R.id.btnRegisterPage);

        btnLoginPage.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,Login.class)));
        btnRegisterPage.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,Register.class)));
    }
}