package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class wordAdapter extends ArrayAdapter {
//
  private int mColorResourceId;
    public wordAdapter(Activity context, ArrayList<word> words,int colorResourceId){
        super(context,0,words);
      mColorResourceId= colorResourceId;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View listitemview = convertView;
       if (listitemview== null){
           listitemview = LayoutInflater.from(getContext()).inflate(R.layout.list_view,parent,false);
       }

       word currentWord = (word) getItem(position);

        TextView miwokTextview = (TextView) listitemview.findViewById(R.id.miwok_text);
        miwokTextview.setText(currentWord.getMiwokTranslation());

        TextView defaultTextview = (TextView) listitemview.findViewById(R.id.default_text);
        defaultTextview.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listitemview.findViewById(R.id.image);
        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResource());
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            imageView.setVisibility(View.GONE);
        }
//
       View textcontainer = listitemview.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(),mColorResourceId);
        return listitemview;
    }
}
