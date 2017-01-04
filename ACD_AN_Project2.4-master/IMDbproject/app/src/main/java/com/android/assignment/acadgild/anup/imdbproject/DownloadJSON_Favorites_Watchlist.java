package com.android.assignment.acadgild.anup.imdbproject;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;



public class DownloadJSON_Favorites_Watchlist extends AsyncTask <Void, Void, Void> {

    private Context context = null;
    int mode = 0;
    ArrayList<IMDB> arrayList_imdb;
    IMDB imdb;
    DBHelper dbHelper = new DBHelper(context);
    private ArrayList<HashMap<String, String>> arrayList;
    private JSONObject jsonObject;
    private String url_fav;

    public DownloadJSON_Favorites_Watchlist(Context context, int mode) {
        this.context = context;
        this.mode = mode;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        arrayList_imdb = new ArrayList<>();
        arrayList_imdb.clear();

        if (mode == 1) {
            arrayList_imdb = dbHelper.get_favorite_entries();
            Log.e("Fav entry", String.valueOf(arrayList_imdb));
        } else if (mode == 2) {
            arrayList_imdb = dbHelper.get_watchlist_entries();
        }

        arrayList = new ArrayList<>();

        JSONdata jsoNdata = new JSONdata();
        try {
            for (int i = 0; i < arrayList_imdb.size(); i++) {
                url_fav = "http://api.themoviedb.org/3/movie/" + arrayList_imdb.get(i).getMovie_id()
                        + "?api_key=8496be0b2149805afa458ab8ec27560c";
                jsonObject = jsoNdata.getJSONFromURL(url_fav);
                HashMap<String, String> hashMap = new HashMap<>();

                hashMap.put("id", jsonObject.getString("id"));
                hashMap.put("original_title", jsonObject.getString("original_title"));
                hashMap.put("release_date", jsonObject.getString("release_date"));
                hashMap.put("popularity", jsonObject.getString("popularity"));
                hashMap.put("vote_count", jsonObject.getString("vote_count"));
                hashMap.put("vote_average", jsonObject.getString("vote_average"));
                hashMap.put("poster_path", "http://image.tmdb.org/t/p/original" +
                        jsonObject.getString("poster_path"));
                arrayList.add(hashMap);
            }

        } catch (JSONException e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
