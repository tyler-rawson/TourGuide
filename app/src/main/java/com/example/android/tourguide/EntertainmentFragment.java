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
public class EntertainmentFragment extends Fragment {
    public EntertainmentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);
        final ArrayList<Location> entertainmentArrayList = new ArrayList<>();
        if (entertainmentArrayList.isEmpty()) {
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_1), getString(R.string.entertainment_hours_1), getString(R.string.entertainment_address_1), getString(R.string.entertainment_phone_1), R.drawable.hollywood_theatre));
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_2), getString(R.string.entertainment_hours_2), getString(R.string.entertainment_address_2), getString(R.string.entertainment_phone_2), R.drawable.laurelhurst));
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_3), getString(R.string.entertainment_hours_3), getString(R.string.entertainment_address_3), getString(R.string.entertainment_phone_3), R.drawable.living_room_theaters));
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_4), getString(R.string.entertainment_hours_4), getString(R.string.entertainment_address_4), getString(R.string.entertainment_phone_4), R.drawable.moda_center));
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_5), getString(R.string.entertainment_hours_5), getString(R.string.entertainment_address_5), getString(R.string.entertainment_phone_5), R.drawable.oaks_amusement_park));
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_6), getString(R.string.entertainment_hours_6), getString(R.string.entertainment_address_6), getString(R.string.entertainment_phone_6), R.drawable.oregonzoo));
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_7), getString(R.string.entertainment_hours_7), getString(R.string.entertainment_address_7), getString(R.string.entertainment_phone_7), R.drawable.portland_spirit_cruises));
            entertainmentArrayList.add(new Location(getActivity(), getString(R.string.entertainment_name_8), getString(R.string.entertainment_hours_8), getString(R.string.entertainment_address_8), getString(R.string.entertainment_phone_8), R.drawable.portland_underground_tour));
        }
        LocationAdapter adapter = new LocationAdapter(getActivity(), entertainmentArrayList, R.color.category_entertainment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // set the layout manager
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
