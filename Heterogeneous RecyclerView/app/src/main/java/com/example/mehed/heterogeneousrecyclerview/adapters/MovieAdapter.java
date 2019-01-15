package com.example.mehed.heterogeneousrecyclerview.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mehed.heterogeneousrecyclerview.R;
import com.example.mehed.heterogeneousrecyclerview.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private Context context;
    private ArrayList<Movie> movieArrayList;
    private static MyOnClik myOnClik;

    public interface MyOnClik {
        void onClick(int position);
    }

    public void setMyOnClik(MyOnClik clickListener) {

        myOnClik = clickListener;
    }

    public MovieAdapter(MyOnClik myOnClik) {
        MovieAdapter.myOnClik = myOnClik;
    }

    public MovieAdapter(Context context, ArrayList<Movie> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_single_row, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.movieName.setText(movieArrayList.get(i).getMovieName());
        movieViewHolder.movieCompanyName.setText(movieArrayList.get(i).getCompanyName());
        movieViewHolder.movieImage.setImageResource(movieArrayList.get(i).getMovieImage());
    }


    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }

    static class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView movieName;
        TextView movieCompanyName;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.ivThor);
            movieName = itemView.findViewById(R.id.tvMovie);
            movieCompanyName = itemView.findViewById(R.id.tvCompanany);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        myOnClik.onClick(position);
                    }
                }
            });
        }
    }
}
