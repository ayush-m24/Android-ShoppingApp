package com.example.shoppingapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsPage extends AppCompatActivity {

    private RecyclerView myRecyclerView;
    private ArrayList<Product> myProducts = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productspage_layout);

        myRecyclerView= findViewById(R.id.myRecyclerView);

        Product p1 = new Product("Coca-Cola 1.5l",10,5,R.drawable.cocacola);
        Product p2 = new Product("Fanta can",15,2,R.drawable.fanta);
        Product p3 = new Product("Sprite can",15,2,R.drawable.sprite);
        Product p4 = new Product("Mountain Dew can",8,2,R.drawable.mountaindew);
        Product p5 = new Product("Pepsi 1l",15,4,R.drawable.pepsi1l);
        Product p6 = new Product("Pepsi can",12,2,R.drawable.pepsicsn);
        Product p7 = new Product("Coca-Cola can",12,2,R.drawable.cokecan);
        Product p8 = new Product("RedBull can",15,3,R.drawable.redbull);

        myProducts.add(p1);
        myProducts.add(p2);
        myProducts.add(p3);
        myProducts.add(p4);
        myProducts.add(p5);
        myProducts.add(p6);
        myProducts.add(p7);
        myProducts.add(p8);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView.setLayoutManager(layoutManager);
        MyAdapter listAdapter = new MyAdapter(myProducts, this);
        myRecyclerView.setAdapter(listAdapter);
    }


}

