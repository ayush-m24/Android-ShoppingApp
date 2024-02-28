package com.example.shoppingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<ItemHolder>{

    private ArrayList<Product> myProducts;
    private Basket myBasket;
    private Context myContext;

    public MyAdapter(ArrayList<Product> myProducts, Context myContext) {
        this.myProducts = myProducts;
        this.myContext = myContext;
        myBasket = new Basket(myContext);
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.recyclerview_item_layout, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {

        final Product currentProduct = myProducts.get(position);

        // Set the data to the views here
        holder.setBasket(myBasket);
        holder.setProductNameText(currentProduct.getProductName());
        holder.setProductImageview(currentProduct.getProductImagecode());
        holder.setProductQuantitySpinner(currentProduct.getProductQuantity());
        holder.setProductPriceText(currentProduct.getProductPrice());
    }

    @Override
    public int getItemCount() {
        return myProducts.size();
    }


}


