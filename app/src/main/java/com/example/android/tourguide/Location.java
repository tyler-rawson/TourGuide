package com.example.android.tourguide;

import android.content.Context;

/**
 * {@link Location} represents a location in Portland.
 */
public class Location {
    /**
     * The constant integer that represents no image was provided.
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    private Context mContext;
    private String mLocationTitle;
    private String mLocationAddress;
    private String mLocationHours;
    private String mLocationPhoneNumber;
    /**
     * The image id of the selected location.
     */
    private int mLocationImageId = NO_IMAGE_PROVIDED;

    /**
     * Create an object that contains a title, hours, address, phone number, and image.
     *
     * @param LocationTitle       is the title or name of the selected location.
     * @param LocationHours       is the hours for the selected location.
     * @param LocationAddress     is the address for the selected location.
     * @param LocationPhoneNumber is the phone number for the selected location.
     * @param LocationImageId     is the image id for the selected location.
     */
    public Location(Context Context, String LocationTitle, String LocationHours, String LocationAddress, String LocationPhoneNumber, int LocationImageId) {
        this(Context, LocationTitle, LocationHours, LocationAddress, LocationImageId); // chain constructors to avoid repeating code
        this.mLocationPhoneNumber = LocationPhoneNumber;
    }

    /**
     * Create an object that only contains a title, hours, and an address, and image.
     * Some locations, such as parks, may not have a phone number. This constructor addresses this.
     *
     * @param LocationTitle   is the title or name of the selected location.
     * @param LocationHours   is the hours for the selected location.
     * @param LocationAddress is the address for the selected location.
     * @param LocationImageId is the imagie id for the selected location.
     */
    public Location(Context Context, String LocationTitle, String LocationHours, String LocationAddress, int LocationImageId) {
        this.mLocationTitle = LocationTitle;
        this.mLocationHours = LocationHours;
        this.mLocationAddress = LocationAddress;
        this.mLocationImageId = LocationImageId;
        this.mContext = Context;
    }

    /**
     * Create an object that only contains a title, hours, and an address, and image.
     * Some locations have a name, hours, and address without an available image.
     *
     * @param LocationTitle   is the title or name of the selected location.
     * @param LocationHours   is the hours for the selected location.
     * @param LocationAddress is the address for the selected location.
     */
    public Location(Context Context, String LocationTitle, String LocationHours, String LocationAddress) {
        this.mLocationTitle = LocationTitle;
        this.mLocationHours = LocationHours;
        this.mLocationAddress = LocationAddress;
        this.mContext = Context;
    }

    public String getLocationTitle() {
        return mLocationTitle;
    }

    public String getLocationAddress() {
        if (mLocationAddress != null && mLocationAddress.length() > 0) { // ensure the string isn't empty (length=0) or null (non-initialized)
            return mLocationAddress;
        } else {
            return mContext.getResources().getString(R.string.unknown_address); // otherwise return "Unknown address"
        }
    }

    public String getLocationHours() {
        if (mLocationHours != null && mLocationHours.length() > 0) {
            return mContext.getResources().getString(R.string.hours) + mLocationHours; // format as "Hours: 7a-7p".
        } else {
            return mContext.getResources().getString(R.string.unknown_hours); // otherwise return "Unknown hours"
        }
    }

    public String getLocationPhoneNumber() {
        if (mLocationPhoneNumber != null && mLocationPhoneNumber.length() > 0) {
            return mLocationPhoneNumber;
        } else {
            return mContext.getResources().getString(R.string.unknown_phone_number); // otherwise return "Unknown phone"
        }
    }

    /**
     * Return the resourceID of the image that goes with each set of words.
     */
    public int getImageResourceId() {
        return mLocationImageId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mLocationImageId != NO_IMAGE_PROVIDED;
    }

}
