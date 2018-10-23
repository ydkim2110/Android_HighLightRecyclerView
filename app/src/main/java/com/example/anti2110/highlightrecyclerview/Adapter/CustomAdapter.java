package com.example.anti2110.highlightrecyclerview.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anti2110.highlightrecyclerview.Common.Common;
import com.example.anti2110.highlightrecyclerview.Interface.ItemClickListener;
import com.example.anti2110.highlightrecyclerview.Model.Item;
import com.example.anti2110.highlightrecyclerview.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private List<Item> items;
    private Context context;

    private int rowIndex = -1; // Default no row choose

    public CustomAdapter(List<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView =  LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);

        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textView.setText(items.get(position).getName());

        if(!items.get(position).isChecked()) {
            holder.imageView.setImageResource(R.drawable.ic_clear_black_24dp);
        } else {
            holder.imageView.setImageResource(R.drawable.ic_check_black_24dp);
        }

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                rowIndex = position; // set row index to selected position
                Common.currentItem = items.get(position); // set current item is item selection
                notifyDataSetChanged(); // made effect on recyclerview's adapter
            }
        });

        // set highlight color
        if(rowIndex == position) {
            holder.itemView.setBackgroundColor(Color.parseColor("#F8F8FA"));
            holder.textView.setTextColor(Color.parseColor("#c5c5c7"));
        } else {
            holder.itemView.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.textView.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;
        private ImageView imageView;

        ItemClickListener itemClickListener;

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            imageView = itemView.findViewById(R.id.image_view);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            itemClickListener.onClick(view, getAdapterPosition());
        }
    }

}
