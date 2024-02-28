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


public class Login extends AppCompatActivity {
    EditText phoneNo, inputPassword;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView btn=findViewById(R.id.textViewRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });


        phoneNo=findViewById(R.id.phoneNo);
        inputPassword=findViewById(R.id.inputPassword);
        btnlogin=findViewById(R.id.btnlogin);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_customer = database.getReference("Customer");

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //ProgressDialog pDialog = new ProgressDialog(Login.this);
                //pDialog.setMessage("Please wait...");
                //pDialog.show();

                table_customer.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.child(phoneNo.getText().toString()).exists()) {
                            //Validate customers information
                            //pDialog.dismiss();
                            User user = snapshot.child(phoneNo.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(inputPassword.getText().toString()))
                            {
                                Toast.makeText(Login.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Login.this, ProductsPage.class);
                                startActivity(i);
                            }
                            else
                            {
                                Toast.makeText(Login.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            //pDialog.dismiss();
                            Toast.makeText(Login.this,"User does not exist",Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });

    }
}
