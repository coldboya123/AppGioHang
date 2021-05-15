package com.example.appgiohang23032021.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appgiohang23032021.R;
import com.example.appgiohang23032021.models.Product;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    private List<Product> list;
    private Context context;

    public CartAdapter(List<Product> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item_cart, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list!=null && list.size()>0 ? list.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView txtname, txtprice, txtquantity, btnminus, btnplush;
        Product product;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}
