package com.example.appgiohang23032021.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appgiohang23032021.CartActivity;
import com.example.appgiohang23032021.ProductListActivity;
import com.example.appgiohang23032021.R;
import com.example.appgiohang23032021.models.Product;
import com.example.appgiohang23032021.models.SaleOff;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> mListProduct;
    private Context context;

    public ProductAdapter(List<Product> mListProduct) {
        this.mListProduct = mListProduct;

    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Product currentProduct = mListProduct.get(position);
        if (currentProduct == null) {
            return;
        }
        holder.imgProduct.setImageResource(currentProduct.getImage());
        holder.tvProductTitle.setText(currentProduct.getName());
        holder.tvProductPrice.setText(ProductListActivity.mNumberFormat.format(currentProduct.getPrice()) + " Đ");

        if (currentProduct.getSaleOff().getPercent() <= 0){
            holder.imgSale.setVisibility(View.GONE);
        }else{
            holder.imgSale.setVisibility(View.VISIBLE);
        }
        holder.linearLayout.setOnClickListener(v -> {
            ProductListActivity.mListProduct.get(position).setSelected(true);
            Intent intent = new Intent(context, CartActivity.class);
//            intent.putExtra("product", currentProduct);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return mListProduct!= null && mListProduct.size() > 0 ? mListProduct.size() : 0;

    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgProduct,imgSale;
        private TextView tvProductTitle, tvBuy;
        private TextView tvProductPrice;
        private LinearLayout linearLayout;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imgProduct = itemView.findViewById(R.id.img_placeholder);
            tvProductTitle = itemView.findViewById(R.id.tv_product_title_item);
            tvProductPrice = itemView.findViewById(R.id.tv_price_item);
            tvBuy = itemView.findViewById(R.id.tv_buy_item);
            imgSale = itemView.findViewById(R.id.img_sale);
            linearLayout = itemView.findViewById(R.id.block);



            tvBuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
