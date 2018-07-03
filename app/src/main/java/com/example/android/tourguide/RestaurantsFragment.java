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
public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);
        final ArrayList<Location> restaurantArrayList = new ArrayList<Location>();
        restaurantArrayList.add(new Location(getActivity(), "Afuri", "11:30AM–10PM", "923 SE 7th Ave", "(503) 468-5001", R.drawable.afuri));
        restaurantArrayList.add(new Location(getActivity(), "Dame", "5PM-10PM", "2930 NE Killingsworth St", "(503) 227-2669", R.drawable.dame));
        restaurantArrayList.add(new Location(getActivity(), "Guero", "11AM-10PM", "200 NE 28th Ave", "(503) 887-9258", R.drawable.guero));
        restaurantArrayList.add(new Location(getActivity(), "Jacqueline", "5PM-10PM", "2039 SE Clinton St", "(503) 327-8637", R.drawable.jacqueline));
        restaurantArrayList.add(new Location(getActivity(), "OP Wurst", "11AM-10PM", "126 SW 2nd Ave", "(971) 386-2199", R.drawable.op_wurst));
        restaurantArrayList.add(new Location(getActivity(), "Q Restaurant & Bar", "11AM-12AM", "828 SW 2nd Ave", "(503) 850-8915", R.drawable.q_restaurant));
        restaurantArrayList.add(new Location(getActivity(), "Tusk", "5PM-10PM", "2448 E Burnside St", "(503) 894-8082", R.drawable.tusk));
        restaurantArrayList.add(new Location(getActivity(), "XLB", "11AM-3PM, 5PM-10PM", "4090 N Williams Ave", "(503) 841-5373", R.drawable.xlb));
        LocationAdapter adapter = new LocationAdapter(getActivity(), restaurantArrayList, R.color.category_restaurants);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // set the layout manager
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        return rootView;
    }

}
