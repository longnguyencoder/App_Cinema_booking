package com.example.moviesappbookingusingapi.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesappbookingusingapi.R;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ViewHolder> {
    List<String> image;
    Context context;
    @NonNull
    @Override
    public ImageListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhodel_detail_images,parent,false);
       context= parent.getContext();
       return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageListAdapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(image.get(position))
                .into(holder.pic);
    }

    public ImageListAdapter(List<String> image) {
        this.image = image;
    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pic= itemView.findViewById(R.id.itemImage);
        }
    }
}
