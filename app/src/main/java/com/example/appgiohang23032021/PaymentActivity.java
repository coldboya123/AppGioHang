package com.example.appgiohang23032021;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appgiohang23032021.models.Product;

public class PaymentActivity extends AppCompatActivity {

    private TextView txttotal, txtdiscount, txttotalpayment;
    private Button btnpay;
    private Product product;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        init();

        for (Product item : ProductListActivity.mListProduct) {
            if (item.isSelected()) {
                product = item;
                position = ProductListActivity.mListProduct.indexOf(item);
                break;
            }
        }
        double total = product.getPrice() * product.getCount();
        txttotal.setText(ProductListActivity.mNumberFormat.format(total) + " Đ");
        txtdiscount.setText(product.getSaleOff().getPercent() + " %");
        txttotalpayment.setText(ProductListActivity.mNumberFormat.format((total - total * product.getSaleOff().getPercent() / 100) - total * 0.1) + " Đ");
        btnpay.setOnClickListener(v -> {
            ProductListActivity.mListProduct.get(position).setCount(0);
            ProductListActivity.mListProduct.get(position).setSelected(false);
            startActivity(new Intent(this, ProductListActivity.class));
        });
    }

    private void init() {
        txttotal = findViewById(R.id.total);
        txtdiscount = findViewById(R.id.discount);
        txttotalpayment = findViewById(R.id.totalpayment);
        btnpay = findViewById(R.id.btnpay);
    }
}