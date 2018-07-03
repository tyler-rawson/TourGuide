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
        final ArrayList<Location> entertainmentArrayList = new ArrayList<Location>();
        entertainmentArrayList.add(new Location(getActivity(), "Hollywood Theatre", "8AM-5PM", "4122 NE Sandy Blvd", "(503) 493-1128", R.drawable.hollywood_theatre));
        entertainmentArrayList.add(new Location(getActivity(), "Laurelhurst Theater", "9AM-10PM", "2735 E Burnside St", "(503) 232-5511", R.drawable.laurelhurst));
        entertainmentArrayList.add(new Location(getActivity(), "Living Room Theaters", "11AM-10PM", "341 SW 10th Ave", "(971) 222-2010", R.drawable.living_room_theaters));
        entertainmentArrayList.add(new Location(getActivity(), "Moda Center", "", "1 N Center Ct St", "(503) 235-8771", R.drawable.moda_center));
        entertainmentArrayList.add(new Location(getActivity(), "Oaks Amusement Park", "12PM-10PM", "7805 SE Oaks Park Way", "(503) 233-5777", R.drawable.oaks_amusement_park));
        entertainmentArrayList.add(new Location(getActivity(), "Oregon Zoo", "9:30AM-6:00PM", "4001 Southwest Canyon Road", "(503) 226-1561", R.drawable.oregonzoo));
        entertainmentArrayList.add(new Location(getActivity(), "Portland Spirit Cruises & Events", "8AM-5:30PM", "110 SE Caruthers St", "(503) 224-3900", R.drawable.portland_spirit_cruises));
        entertainmentArrayList.add(new Location(getActivity(), "Shanghai Tunnels / Portland Underground Tour", "9AM-11PM", "120 NW 3rd Ave", "(503) 622-4798", R.drawable.portland_underground_tour));
        LocationAdapter adapter = new LocationAdapter(getActivity(), entertainmentArrayList, R.color.category_entertainment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // set the layout manager
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
