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
        final ArrayList<Location> restaurantArrayList = new ArrayList<>();
        if (restaurantArrayList.isEmpty()) {
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_1), getString(R.string.restaurant_hours_1), getString(R.string.restaurant_address_1), getString(R.string.restaurant_phone_1), R.drawable.afuri));
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_2), getString(R.string.restaurant_hours_2), getString(R.string.restaurant_address_2), getString(R.string.restaurant_phone_2), R.drawable.dame));
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_3), getString(R.string.restaurant_hours_3), getString(R.string.restaurant_address_3), getString(R.string.restaurant_phone_3), R.drawable.guero));
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_4), getString(R.string.restaurant_hours_4), getString(R.string.restaurant_address_4), getString(R.string.restaurant_phone_4), R.drawable.jacqueline));
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_5), getString(R.string.restaurant_hours_5), getString(R.string.restaurant_address_5), getString(R.string.restaurant_phone_5), R.drawable.op_wurst));
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_6), getString(R.string.restaurant_hours_6), getString(R.string.restaurant_address_6), getString(R.string.restaurant_phone_6), R.drawable.q_restaurant));
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_7), getString(R.string.restaurant_hours_7), getString(R.string.restaurant_address_7), getString(R.string.restaurant_phone_7), R.drawable.tusk));
            restaurantArrayList.add(new Location(getActivity(), getString(R.string.restaurant_name_8), getString(R.string.restaurant_hours_8), getString(R.string.restaurant_address_8), getString(R.string.restaurant_phone_8), R.drawable.xlb));
        }
        LocationAdapter adapter = new LocationAdapter(getActivity(), restaurantArrayList, R.color.category_restaurants);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); // set the layout manager
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        return rootView;
    }
}
