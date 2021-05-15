package com.example.appgiohang23032021;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgiohang23032021.models.Product;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private ImageView img;
    private TextView txtname, txtprice, txtquantity, btnminus, btnplush;
    private Button btnbuy, btncancel;
    private Product product;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        init();

        for (Product item : ProductListActivity.mListProduct) {
            if (item.isSelected()) {
                product = item;
                position = ProductListActivity.mListProduct.indexOf(item);
                break;
            }
        }
        img.setImageResource(product.getImage());
        txtname.setText(product.getName());
        txtprice.setText(ProductListActivity.mNumberFormat.format(product.getPrice()) + " Đ");
        btnplush.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnbuy.setOnClickListener(this);
        btncancel.setOnClickListener(this);
    }

    private void init() {
        img = findViewById(R.id.img);
        txtname = findViewById(R.id.name);
        txtprice = findViewById(R.id.price);
        txtquantity = findViewById(R.id.quantity);
        btnminus = findViewById(R.id.btnminus);
        btnplush = findViewById(R.id.btnplush);
        btnbuy = findViewById(R.id.btnbuy);
        btncancel = findViewById(R.id.btncancel);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnminus:
                int quantity = Integer.parseInt(txtquantity.getText().toString());
                if (quantity > 0) {
                    quantity--;
                    txtquantity.setText(quantity + "");
                }
                break;
            case R.id.btnplush:
                int quantity1 = Integer.parseInt(txtquantity.getText().toString());
                quantity1++;
                txtquantity.setText(quantity1 + "");
                break;
            case R.id.btnbuy:
                ProductListActivity.mListProduct.get(position).setCount(Integer.parseInt(txtquantity.getText().toString()));
                startActivity(new Intent(CartActivity.this, PaymentActivity.class));
                break;
            case R.id.btncancel:
                ProductListActivity.mListProduct.get(position).setSelected(false);
                finish();
                break;
        }
    }
}