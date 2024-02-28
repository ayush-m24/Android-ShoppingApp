package com.example.shoppingapp;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ItemHolder extends RecyclerView.ViewHolder {

    private final TextView productNameText;
    private final TextView productPriceText;
    private final TextView quantityAddedText;
    private final ImageView productImageview;
    private final Spinner productQuantitySpinner;
    private final Button btnAddToBasket;
    private final Button btnRemoveFromBasket;
    private Basket myBasket; // Basket Class object

    public void setBasket(Basket myBasket) {
        this.myBasket = myBasket;
    }

    public void setProductNameText(String productNameText) {
        this.productNameText.setText(productNameText);
    }

    public void setProductPriceText(int  productPrice) {
        String productPriceStr = ""+productPrice;
        this.productPriceText.setText(productPriceStr);
    }

    public void setProductImageview(int pictureCode) {
        this.productImageview.setImageResource(pictureCode);
    }

    public void setProductQuantitySpinner(int quantity) {

        Integer [] totalQuantity;
        totalQuantity = new Integer[quantity];

        for (int i=0; i<quantity; i++)
            totalQuantity[i]=i+1;

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(itemView.getContext(), android.R.layout.simple_spinner_item, totalQuantity );
        adapter.setDropDownViewResource(R.layout.spinner_layout);
        productQuantitySpinner.setAdapter(adapter);

    }

    @SuppressLint("SetTextI18n")
    public ItemHolder(@NonNull View itemView) {
        super(itemView);

        productImageview = itemView.findViewById(R.id.productImageView);
        productNameText = itemView.findViewById(R.id.productNameTextView);
        productPriceText = itemView.findViewById(R.id.productPriceTextView);
        productQuantitySpinner = itemView.findViewById(R.id.spinnerQuantity);
        quantityAddedText = itemView.findViewById(R.id.productQuantityAdded);
        btnAddToBasket = itemView.findViewById(R.id.btnAddToBasket);
        btnRemoveFromBasket=itemView.findViewById(R.id.btnRemoveFromBasket);

        btnRemoveFromBasket.setVisibility(View.GONE); // remove Basket item is invisible now



        btnAddToBasket.setOnClickListener(v -> {

            Product p = SelectedProduct();

            myBasket.addToBasket(p);
            btnAddToBasket.setVisibility(View.GONE); // add Basket button is invisible
            btnRemoveFromBasket.setVisibility(View.VISIBLE);
            quantityAddedText.setText(p.getProductQuantity() + " added to the basket");
            productQuantitySpinner.setVisibility(View.GONE);
            myBasket.showBasket();

        });

        btnRemoveFromBasket.setOnClickListener(v -> {

            Product p = SelectedProduct();


            myBasket.removeFromBasket(p);
            btnAddToBasket.setVisibility(View.VISIBLE);
            btnRemoveFromBasket.setVisibility(View.GONE);
            quantityAddedText.setText("Quantity in Stock:");
            productQuantitySpinner.setVisibility(View.VISIBLE);
            myBasket.showBasket();

        });



    }

    private Product SelectedProduct() {

        String p_name = productNameText.getText().toString();
        String p_price_str = productPriceText.getText().toString();
        int p_code = productImageview.getId();
        String p_quantity_str = productQuantitySpinner.getSelectedItem().toString();

        int p_quantity;
        int p_price;

        try{
            p_price = Integer.parseInt(p_price_str);
            p_quantity = Integer.parseInt(p_quantity_str);
        }
        catch (Exception e){
            p_price=0;
            p_quantity=0;
            Log.e("PROBLEM IN INTEGER",e.getMessage());
        }


        Product p = new Product(p_name,p_quantity,p_price,p_code);

        return p;
    }
}
