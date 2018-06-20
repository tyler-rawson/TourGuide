package com.example.android.miwok;

/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains both a default and Miwok translation of that word.
 */
public class Word {
    /**
     * The default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * The Miwok translation for the word
     */
    private String mMiwokTranslation;


    /**
     * The constant integer that represents no image was provided.
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * The resourceID of the image that goes with each set of words.
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private int mAudioResourceId = -1;

    /**
     * @param defaultTranslation is the word in the language the user is familiar with (eg, English).
     * @param miwokTranslation   is the Miwok translation of the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceID) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mAudioResourceId = audioResourceID;
    }

    /**
     * @param defaultTranslation is the word in the language the user is familiar with (eg, English).
     * @param miwokTranslation   is the Miwok translation of the word
     * @param imageResourceID    is the drawable resource ID of the image
     * @param audioResourceID    is the audio resource ID of the word
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID, int audioResourceID) {
        this.mDefaultTranslation = defaultTranslation;
        this.mMiwokTranslation = miwokTranslation;
        this.mImageResourceId = imageResourceID;
        this.mAudioResourceId = audioResourceID;
    }

    /*Returns default translation*/
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /*Returns Miwok translation*/
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Return the resourceID of the image that goes with each set of words.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Return the audio resourceID that goes with each Miwok word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
