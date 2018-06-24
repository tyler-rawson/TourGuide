package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private Context context;
    private List<Word> words;

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;

    public WordAdapter(Context context, List<Word> words, int colorResourceId) {
        this.context = context; // save these for later use
        this.words = words;
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public WordAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //onCreate will inflate views that can later be recycled by onBind
        return new ViewHolder(LayoutInflater.from(context).inflate(
                R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {
        //onBind will utilize views that have already been created
        final Word currentWord = words.get(position); // get the object at this position in the list
        TextView miwokTextView = viewHolder.textViewPrimary; // set this text on the name TextView
        TextView defaultTextView = viewHolder.textViewSecondary; // set this text on the number TextView
        ImageView image = viewHolder.image;
        View textContainer = viewHolder.textContainer;
        miwokTextView.setText(currentWord.getMiwokTranslation()); // Find the TextView in the list_item.xml layout with the ID version_number
        defaultTextView.setText(currentWord.getDefaultTranslation()); // Return the whole list item layout (containing 2 TextViews and an ImageView)
        if (currentWord.hasImage()) {
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        } else {
            image.setVisibility(View.GONE);
        }
        int color = ContextCompat.getColor(context, mColorResourceId); // find the color that the resource ID maps to
        textContainer.setBackgroundColor(color); // set the background color of the text container View
    }

    @Override
    public int getItemCount() {
        if (words == null) return 0; //if words list is empty return zero
        else return this.words.size(); // else return size of words list
    }

    /**
     * ViewHolder results in better performance so we don't have to findViewById every time onBindViewHolder() is accessed.
     * Views are stored for easy access later on.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        // create variables
        private View textContainer;
        private TextView textViewPrimary;
        private TextView textViewSecondary;
        private ImageView image;
        private View playIcon;

        public ViewHolder(@NonNull View view) {
            // find views and assign for later use
            super(view); // use constructor of super
            this.textContainer = view.findViewById(R.id.text_container);
            this.textViewPrimary = view.findViewById(R.id.textViewPrimary);
            this.textViewSecondary = view.findViewById(R.id.textViewSecondary);
            this.image = view.findViewById(R.id.image);


        }
    }
}
