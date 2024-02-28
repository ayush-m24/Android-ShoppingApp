package com.example.shoppingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shoppingapp.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends AppCompatActivity {

    EditText name, phone, password;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name=findViewById(R.id.fullName);
        phone=findViewById(R.id.phoneNo);
        password=findViewById(R.id.inputPassword);

        btnRegister= (Button) findViewById(R.id.btnRegister);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_customer = database.getReference("Customer");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                table_customer.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Validate if user already exists
                        if (snapshot.child(phone.getText().toString()).exists())
                        {
                            Toast.makeText(Register.this, "Phone Number is registered", Toast.LENGTH_SHORT).show();
                        }
                        //Adds new user data to firebase
                        else
                        {
                            User user = new User(name.getText().toString(), password.getText().toString());
                            table_customer.child(phone.getText().toString()).setValue(user);
                            Toast.makeText(Register.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent i = new Intent(Register.this, ProductsPage.class);
                            startActivity(i);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });






//
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = name.getText().toString().trim();
//                Integer number = Integer.valueOf(phone.getClass().toString().trim());
//                String pass = password.getText().toString().trim();
//
//
                if (user.isEmpty())
                {
                    name.setError("Enter Full Name");
                    name.requestFocus();
                    return;
                }
//
//                if (number.equals(0))
//                {
//                    phone.setError("Enter Email");
//                    phone.requestFocus();
//                    return;
//                }
//
//                if (pass.isEmpty())
//                {
//                    password.setError("Enter Password");
//                    password.requestFocus();
//                    return;
//                }
//
//                if (pass!=confirmpass)
//                {
//                    inputConfirmPasswordWrapper.setError("Password does not match");
//                    inputConfirmPasswordWrapper.requestFocus();
//                    return;
//                }
            }
        });



        TextView btn=findViewById(R.id.alreadyExists);
        btn.setOnClickListener(view -> startActivity(new Intent(Register.this,Login.class)));

    }


}
