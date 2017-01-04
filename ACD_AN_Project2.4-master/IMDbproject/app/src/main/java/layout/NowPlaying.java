package layout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.assignment.acadgild.anup.imdbproject.DownloadJSON;
import com.android.assignment.acadgild.anup.imdbproject.R;

public class NowPlaying extends Fragment {

    public NowPlaying() {
    }

    RecyclerView lv_nowPlaying;
    public View view_nowPlaying;
    String URL_NP = "http://api.themoviedb.org/3/movie/now_playing?api_key=8496be0b2149805afa458ab8ec27560c";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onPause() {
        setRetainInstance(true);
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onViewCreated(container, savedInstanceState);
        view_nowPlaying = inflater.inflate(R.layout.fragment_now_playing, container, false);
        lv_nowPlaying = (RecyclerView) view_nowPlaying.findViewById(R.id.recyclerView_nowPlaying);
        loadRecyclerViewData();
        return view_nowPlaying;
    }

    private void loadRecyclerViewData(){
        DownloadJSON downloadJSON = new DownloadJSON(getActivity().getApplication().getApplicationContext(), lv_nowPlaying);
        downloadJSON.getJSONpageWise(URL_NP);
    }
}






