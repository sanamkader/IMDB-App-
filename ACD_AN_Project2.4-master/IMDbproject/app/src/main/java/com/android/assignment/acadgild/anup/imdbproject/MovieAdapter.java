package com.android.assignment.acadgild.anup.imdbproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.HashMap;

import static com.android.assignment.acadgild.anup.imdbproject.MainActivity.MOVIE_ID;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder>{
    ArrayList<HashMap<String, String>> movielist;
    private HashMap<String, String> currentMovie = new HashMap<>();
    LayoutInflater inflater;
    Context mcontext;
    public ImageLoader imageLoader;
    ProgressBar progressBar;
    private int resource = R.layout.list_item;


    public MovieAdapter(Context context, ArrayList<HashMap<String, String>> movielist) {
        inflater = LayoutInflater.from(context);
        imageLoader = ImageLoader.getInstance();
        this.movielist = movielist;
        this.mcontext = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view_movieList = inflater.inflate(resource, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view_movieList);
        view_movieList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> hashMapIntent = new HashMap<String, String>();
                hashMapIntent = movielist.get(viewHolder.getAdapterPosition());
                Log.e("before intent id ", hashMapIntent.get(MOVIE_ID));
                Log.e("before intent position ", String.valueOf(viewHolder.getAdapterPosition()));
                Intent intent = new Intent(mcontext, Movie_DetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id", hashMapIntent.get(MOVIE_ID));
                mcontext.startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        currentMovie = movielist.get(position);
        holder.imageView_voteCount.setImageResource(R.drawable.ic_star);

        imageLoader.displayImage(currentMovie.get(MainActivity.MOVIE_IMAGE), holder.imageView_movieImage, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                holder.progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                holder.progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                holder.progressBar.setVisibility(View.GONE);
            }
        });

        holder.textView_movieTitle.setText(currentMovie.get(MainActivity.MOVIE_TITLE));
        holder.textView_releaseDate_label.setText(R.string.releaseDate_label);
        holder.textView_releaseDate.setText(currentMovie.get(MainActivity.RELEASE_DATE));
        holder.textView_popularity_label.setText(R.string.popularity);
        holder.ratingBar_popularity.setRating(Float.parseFloat(currentMovie.get(MainActivity.VOTE_AVERAGE))/2);

        String vote_count = "(" + currentMovie.get(MainActivity.VOTE_AVERAGE) + "/10) " +
                "voted by " + currentMovie.get(MainActivity.VOTE_COUNT) + " users.";
        holder.textView_voteCount.setText(vote_count);

    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView_movieImage, imageView_voteCount;
        RatingBar ratingBar_popularity;
        ProgressBar progressBar;
        TextView textView_movieTitle, textView_releaseDate_label, textView_releaseDate, textView_popularity_label, textView_voteCount;

        ViewHolder(final View itemView) {
            super(itemView);
            progressBar = (ProgressBar)itemView.findViewById(R.id.progressbar);
            imageView_movieImage = (ImageView) itemView.findViewById(R.id.imageView_mImage);
            textView_movieTitle = (TextView) itemView.findViewById(R.id.textView_movieTitle);
            textView_releaseDate_label = (TextView) itemView.findViewById(R.id.textView_releaseDate_label);
            textView_releaseDate = (TextView) itemView.findViewById(R.id.textView_releaseDate);
            textView_popularity_label = (TextView) itemView.findViewById(R.id.textView_popularity_label);
            ratingBar_popularity = (RatingBar) itemView.findViewById(R.id.ratingBar_popularity);
            imageView_voteCount = (ImageView) itemView.findViewById(R.id.imageView_voteCount);
            textView_voteCount = (TextView) itemView.findViewById(R.id.textView_voteCount);

        }
    }

}