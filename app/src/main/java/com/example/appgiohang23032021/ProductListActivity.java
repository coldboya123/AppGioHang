package com.example.appgiohang23032021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.appgiohang23032021.adapter.ProductAdapter;
import com.example.appgiohang23032021.models.Product;
import com.example.appgiohang23032021.models.SaleOff;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    public static List<Product> mListProduct;
    public static NumberFormat mNumberFormat = new DecimalFormat("#,###");

    RecyclerView mRcvProduct;
    ProductAdapter mProductAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        mListProduct = Product.getDataMock();

        mRcvProduct = findViewById(R.id.recyclerViewProduct);
        mProductAdapter = new ProductAdapter(mListProduct);

        mRcvProduct.setHasFixedSize(true);
        mRcvProduct.setAdapter(mProductAdapter);
    }
}