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
        final ArrayList<Location> museumArrayList = new ArrayList<>();
        if (museumArrayList.isEmpty()) {
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_1), getString(R.string.museum_hours_1), getString(R.string.museum_address_1), getString(R.string.museum_phone_1), R.drawable.blue_sky));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_2), getString(R.string.museum_hours_2), getString(R.string.museum_address_2), getString(R.string.museum_phone_2), R.drawable.museum_of_gaming_and_puzzlery));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_3), getString(R.string.museum_hours_3), getString(R.string.museum_address_3), getString(R.string.museum_phone_3), R.drawable.oregon_maritime_museum));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_4), getString(R.string.museum_hours_4), getString(R.string.museum_address_4), getString(R.string.museum_phone_4), R.drawable.omsi));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_5), getString(R.string.museum_hours_5), getString(R.string.museum_address_5), getString(R.string.museum_phone_5), R.drawable.pittock_mansion));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_6), getString(R.string.museum_hours_6), getString(R.string.museum_address_6), getString(R.string.museum_phone_6), R.drawable.portland_art_museum));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_7), getString(R.string.museum_hours_7), getString(R.string.museum_address_7), getString(R.string.museum_phone_7), R.drawable.portland_head_light));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_8), getString(R.string.museum_hours_8), getString(R.string.museum_address_8), getString(R.string.museum_phone_8), R.drawable.victoria_mansion));
            museumArrayList.add(new Location(getActivity(), getString(R.string.museum_name_9), getString(R.string.museum_hours_9), getString(R.string.museum_address_9), getString(R.string.museum_phone_9), R.drawable.portland_forestry_center));
        }
        LocationAdapter adapter = new LocationAdapter(getActivity(), museumArrayList, R.color.category_museums);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // set the layout manager
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}