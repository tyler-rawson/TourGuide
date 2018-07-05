package com.example.android.tourguide;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    private Context mContext;
    private List<Location> mLocationList;
    private int mColorResourceId;

    public LocationAdapter(Context mContext, List<Location> locationList, int colorResourceId) {
        this.mContext = mContext; // store these as global variables
        this.mLocationList = locationList;
        this.mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //onCreate will inflate views that can later be recycled by onBind
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        //onBind will utilize views that have already been created
        final Location currentLocation = mLocationList.get(position); // get the object at this position in the list
        ImageView image = viewHolder.image;
        if (currentLocation.hasImage()) {
            Glide.with((mContext))
                    .load(currentLocation.getImageResourceId())
                    .apply(new RequestOptions().placeholder(new ColorDrawable(Color.GRAY)))
                    .into(image);
        } else {
            image.setVisibility(View.GONE);
        }
        FrameLayout frameLayout = viewHolder.frameLayout;
        TextView locationTitle = viewHolder.textViewLocation;
        TextView locationHours = viewHolder.textViewHours;
        TextView locationAddress = viewHolder.textViewAddress;
        TextView locationPhoneNumber = viewHolder.textViewPhoneNumber;
        View textContainer = viewHolder.textContainer;
        locationTitle.setText(currentLocation.getLocationTitle());
        locationAddress.setText(currentLocation.getLocationAddress());
        locationAddress.setPaintFlags(locationAddress.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        locationHours.setText(currentLocation.getLocationHours());
        if (currentLocation.getLocationPhoneNumber().equals(mContext.getResources().getString(R.string.unknown_phone_number))) {
            locationPhoneNumber.setVisibility(View.GONE);
        } else {
            locationPhoneNumber.setText(currentLocation.getLocationPhoneNumber());
        }
        int color = ContextCompat.getColor(mContext, mColorResourceId); // find the color that the resource ID maps to
        textContainer.setBackgroundColor(color); // set the background color of the text container view -- note it is wrap_content so
        frameLayout.setBackgroundColor(color); // we've got to set parent @id/frame_layout this color as well to fill in any background color gaps.
    }

    @Override
    public void onViewRecycled(@NonNull ViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        ImageView image = viewHolder.image;
        Glide.with(mContext).clear(image);
    }

    @Override
    public int getItemCount() {
        if (mLocationList == null) return 0; //if mLocationList list is empty return zero
        else return this.mLocationList.size(); // else return size of list
    }

    /**
     * ViewHolder results in better performance so we don't have to findViewById every time onBindViewHolder() is accessed.
     * Views are stored for easy access later on.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        // create variables
        private FrameLayout frameLayout;
        private View textContainer;
        private TextView textViewLocation;
        private TextView textViewAddress;
        private TextView textViewHours;
        private TextView textViewPhoneNumber;
        private ImageView image;

        public ViewHolder(@NonNull View view) {
            // find views and assign for later use
            super(view); // use constructor of super
            this.frameLayout = view.findViewById(R.id.frame_layout);
            this.textContainer = view.findViewById(R.id.text_container);
            this.textViewLocation = view.findViewById(R.id.textViewLocation);
            this.textViewAddress = view.findViewById(R.id.textViewAddress);
            this.textViewHours = view.findViewById(R.id.textViewHours);
            this.textViewPhoneNumber = view.findViewById(R.id.textViewPhoneNumber);
            this.image = view.findViewById(R.id.imageView);
            textViewAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textViewAddress.getText().equals(mContext.getResources().getString(R.string.unknown_address))) {
                        // do nothing if the address is unknown
                    } else {
                        // Adding ", Portland, OR" in case the user is far away and
                        // there's a duplicate address that is closer to the
                        // user. We want it to naviate to the correct place.
                        String address = "google.navigation:q=" + textViewAddress.getText() + ", Portland, OR";
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(address));
                        PackageManager packageManager = mContext.getPackageManager();
                        if (intent.resolveActivity(packageManager) != null) {
                            mContext.startActivity(intent);
                        } else {
                            Log.e("LocationAdapter onClick", "No intent available to handle action");
                        }
                    }

                }

            });

        }
    }
}
