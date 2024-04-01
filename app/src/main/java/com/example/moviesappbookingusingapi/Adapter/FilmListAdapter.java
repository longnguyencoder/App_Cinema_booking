package com.example.moviesappbookingusingapi.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviesappbookingusingapi.Activity.DetailActivity;
import com.example.moviesappbookingusingapi.Domain.ListFilm;
import com.example.moviesappbookingusingapi.R;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.ViewHolder> {
    ListFilm items;
    Context context;

    @NonNull
    @Override
    public FilmListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewhodel_film,parent,false);
        context= parent.getContext();
        return new ViewHolder(inflate);

    }

    public FilmListAdapter(ListFilm items) {
        this.items = items;
    }

    @Override
    public void onBindViewHolder(@NonNull FilmListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.titletxt.setText(items.getData().get(position).getTitle());
        holder.scoretxt.setText("" +items.getData().get(position).getImdbRating());

        Glide.with(holder.itemView.getContext())
                .load(items.getData().get(position).getPoster())
                .into(holder.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("id",items.getData().get(position).getId());
                holder.itemView.getContext().startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return items.getData().size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView titletxt,scoretxt;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titletxt = itemView.findViewById(R.id.titletxt);
            scoretxt = itemView.findViewById(R.id.scoretxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
