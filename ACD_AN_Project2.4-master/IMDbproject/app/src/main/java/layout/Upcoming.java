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


public class Upcoming extends Fragment {

    public Upcoming() {
    }

    View view_upComing;
    RecyclerView lv_upcoming;
    String URL_UC = "http://api.themoviedb.org/3/movie/upcoming?api_key=8496be0b2149805afa458ab8ec27560c";

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

        view_upComing = inflater.inflate(R.layout.fragment_upcoming, container, false);
        lv_upcoming = (RecyclerView)view_upComing.findViewById(R.id.recyclerView_upComing);
        loadRecyclerViewData();
        return view_upComing;
    }

    private void loadRecyclerViewData(){
        DownloadJSON downloadJSON = new DownloadJSON(getActivity().getApplication().getApplicationContext(), lv_upcoming);
        downloadJSON.getJSONpageWise(URL_UC);
    }

}


