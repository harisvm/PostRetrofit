package com.example.postretrofit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;



    public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.MobileViewHolder> {
        private Context mctx;
        private List<Mobile> mobileList;

        public MobileAdapter(Context mctx, List<Mobile> mobileList) {
            this.mctx = mctx;
            this.mobileList = mobileList;
        }

        @NonNull
        @Override
        public MobileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(mctx).inflate(R.layout.card_mobile,parent,false);
            return new MobileViewHolder(v);
        }

        @Override
        public void onBindViewHolder( MobileViewHolder holder, int position) {
            Mobile mobile = mobileList.get(position);
            holder.name.setText(mobile.getProductName());
            holder.oldPrice.setText(mobile.getOldPrice());
            holder.discount.setText(mobile.getDiscount());
            holder.newPrice.setText(mobile.getNewPrice());
           Picasso.with(mctx).load(mobile.getImageUrl()).into(holder.image);


        }

        @Override
        public int getItemCount() {
            return mobileList.size();
        }

        class MobileViewHolder extends RecyclerView.ViewHolder {
            TextView name,oldPrice,discount,newPrice;
            ImageView image;
            public MobileViewHolder(@NonNull View itemView) {
                super(itemView);

                name = itemView.findViewById(R.id.mobileName);
                oldPrice =itemView.findViewById(R.id.oldPrice);
                discount = itemView.findViewById(R.id.discount);
                newPrice = itemView.findViewById(R.id.newPrice);

                image = itemView.findViewById(R.id.imageView);
            }
        }
    }

