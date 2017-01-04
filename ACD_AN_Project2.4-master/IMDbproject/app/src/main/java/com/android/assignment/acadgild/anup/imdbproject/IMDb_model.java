package com.android.assignment.acadgild.anup.imdbproject;


public class IMDb_model {
    private int movie_id;
    private int is_favorite;
    private int is_watchlist;

    public IMDb_model(int movie_id, int is_favorite, int is_watchlist) {
        this.movie_id = movie_id;
        this.is_favorite = is_favorite;
        this.is_watchlist = is_watchlist;
    }


    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(int is_favorite) {
        this.is_favorite = is_favorite;
    }

    public int getIs_watchlist() {
        return is_watchlist;
    }

    public void setIs_watchlist(int is_watchlist) {
        this.is_watchlist = is_watchlist;
    }

    public IMDb_model() {

    }


}
