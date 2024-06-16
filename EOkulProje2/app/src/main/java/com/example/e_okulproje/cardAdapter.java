package com.example.e_okulproje;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class cardAdapter extends ArrayAdapter<String> {
    private String[] cardTexts;
    private int[] cardImages;
    private Context context;
    private TextView cardText;
    private ImageView cardImage;

    cardAdapter(String[] cardText, int[] cardImage, Context context) {
        super(context, R.layout.card_map, cardText);

        this.cardTexts = cardText;
        this.cardImages = cardImage;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_map, null);

        if (view != null)
        {
            cardText = (TextView) view.findViewById(R.id.cardTextView);
            cardImage = (ImageView) view.findViewById(R.id.cardImageView);

            cardText.setText(cardTexts[position]);
            cardImage.setBackgroundResource(cardImages[position]);

        }
        return view;
    }
}
