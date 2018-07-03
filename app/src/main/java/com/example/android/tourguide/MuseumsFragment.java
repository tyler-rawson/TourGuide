package com.example.android.tourguide;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class MuseumsFragment extends Fragment {

    public MuseumsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);
        final ArrayList<Location> museumArrayList = new ArrayList<Location>();
        museumArrayList.add(new Location(getActivity(), "Blue Sky Gallery", "12PM-5PM", "122 NW 8th Ave", "(503) 225-0210", R.drawable.blue_sky));
        museumArrayList.add(new Location(getActivity(), "Interactive Museum of Gaming and Puzzlery", "10AM-9PM", "15607 SW 116th Ave", "(503) 968-9998", R.drawable.museum_of_gaming_and_puzzlery));
        museumArrayList.add(new Location(getActivity(), "Oregon Maritime Museum ", "11AM-4PM", "198 SW Naito Pkwy", "(503) 224-7724", R.drawable.oregon_maritime_museum));
        museumArrayList.add(new Location(getActivity(), "Oregon Museum of Science and Industry", "9:30AM-7PM", "1945 SE Water Ave", "(503) 797-4000", R.drawable.omsi));
        museumArrayList.add(new Location(getActivity(), "Pittock Mansion", "9AM-5PM", "3229 NW Pittock Dr", "(503) 823-3623", R.drawable.pittock_mansion));
        museumArrayList.add(new Location(getActivity(), "Portland Art Museum", "10AM-8PM", "1219 SW Park Ave", "(503) 226-2811", R.drawable.portland_art_museum));
        museumArrayList.add(new Location(getActivity(), "Portland Head Light", "6AM-6PM", "12 Captain Strout Cir", "(207) 799-2661", R.drawable.portland_head_light));
        museumArrayList.add(new Location(getActivity(), "Victoria Mansion", "10AM-3:45PM", "109 Danforth St", "(503) 970-0213", R.drawable.victoria_mansion));
        museumArrayList.add(new Location(getActivity(), "World Forestry Center", "10AM-5PM", "4033 Southwest Canyon Road", "(503) 228-1367", R.drawable.portland_forestry_center));
        LocationAdapter adapter = new LocationAdapter(getActivity(), museumArrayList, R.color.category_museums);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // set the layout manager
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}