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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.moviesappbookingusingapi.Activity.DetailActivity;
import com.example.moviesappbookingusingapi.Activity.MainActivity;
import com.example.moviesappbookingusingapi.Models.MovieBrief;
import com.example.moviesappbookingusingapi.R;
import com.example.moviesappbookingusingapi.Util.Credentials;

import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.ViewHolder> {
    List<MovieBrief> movieBriefs;
    Context context;
    String email;
    Intent intent;
    public FilmListAdapter(List<MovieBrief> movieBriefs, Context context) {
        this.movieBriefs = movieBriefs;
        this.context = context;
    }

    @NonNull
    @Override
    public FilmListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        intent = ((MainActivity) context).getIntent();
        email = intent.getStringExtra("email");
        return new FilmListAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.viewhodel_film, parent, false));
//        return new ViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull FilmListAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.titletxt.setText(movieBriefs.get(position).getTitle());
//        holder.scoretxt.setText("" +movieBriefs.get(position).);

        Glide.with(context.getApplicationContext()).load(Credentials.IMAGE_LOADING_BASE_URL_342 + movieBriefs.get(position).getPosterPath())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("id",movieBriefs.get(position).getId());
                intent.putExtra("email", email);
                holder.itemView.getContext().startActivities(new Intent[]{intent});
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieBriefs.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        TextView titletxt,scoretxt;
        ImageView pic;
        ConstraintLayout items_movie;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titletxt = itemView.findViewById(R.id.titletxt);
            scoretxt = itemView.findViewById(R.id.scoretxt);
            pic = itemView.findViewById(R.id.pic);
            items_movie =itemView.findViewById(R.id.items_movie);


            /*items_movie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent iDetail = new Intent(context, DetailActivity.class);
                    intent.putExtra("movie_id", movieBriefs.get(getAdapterPosition()).getId());
                    context.startActivity(iDetail);
                }
            });*/
        }
    }
}