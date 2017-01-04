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


public class TopRated extends Fragment {

    public TopRated() {
    }

    View view_topRated;
    RecyclerView lv_topRated;
    String URL_TR = "http://api.themoviedb.org/3/movie/top_rated?api_key=8496be0b2149805afa458ab8ec27560c";

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view_topRated = inflater.inflate(R.layout.fragment_top_rated, container, false);
        lv_topRated = (RecyclerView) view_topRated.findViewById(R.id.recyclerView_topRated);
        loadRecyclerViewData();
        return view_topRated;
    }

    private void loadRecyclerViewData(){
        DownloadJSON downloadJSON = new DownloadJSON(getActivity().getApplication().getApplicationContext(), lv_topRated);
        downloadJSON.getJSONpageWise(URL_TR);
    }
}


