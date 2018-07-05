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
public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);
        final ArrayList<Location> parksArrayList = new ArrayList<Location>();
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_1), getString(R.string.park_hours_1), getString(R.string.park_address_1)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_2), getString(R.string.park_hours_2), getString(R.string.park_address_2)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_3), getString(R.string.park_hours_3), getString(R.string.park_address_3)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_4), getString(R.string.park_hours_4), getString(R.string.park_address_4)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_5), getString(R.string.park_hours_5), getString(R.string.park_address_5)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_6), getString(R.string.park_hours_6), getString(R.string.park_address_6)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_7), getString(R.string.park_hours_7), getString(R.string.park_address_7)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_8), getString(R.string.park_hours_8), getString(R.string.park_address_8)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_9), getString(R.string.park_hours_9), getString(R.string.park_address_9)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_10), getString(R.string.park_hours_10), getString(R.string.park_address_10)));
        parksArrayList.add(new Location(getActivity(), getString(R.string.park_name_11), getString(R.string.park_hours_11), getString(R.string.park_address_11)));
        LocationAdapter adapter = new LocationAdapter(getActivity(), parksArrayList, R.color.category_parks);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // set the layout manager
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
