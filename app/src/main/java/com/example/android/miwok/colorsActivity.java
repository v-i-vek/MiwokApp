package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class colorsActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener onCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<word> words = new ArrayList<word>();
        // word w = new word("luttie" , "one"); this is how the object of constructor work but this is not optimize way ....the following is the oprimize way

        words.add(new word("lal", "red", R.drawable.color_red, R.raw.color_red));
        words.add(new word("peela", "yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new word("hara", "green", R.drawable.color_green, R.raw.color_green));
        words.add(new word("kala", "black", R.drawable.color_black, R.raw.color_black));
        words.add(new word("safed", "white", R.drawable.color_white, R.raw.color_white));
        words.add(new word("bhura", "brown", R.drawable.color_brown, R.raw.color_brown));
        words.add(new word("gray", "gray", R.drawable.color_gray, R.raw.color_gray));
        words.add(new word("halka peela", "light yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));


        wordAdapter numberAdapter = new wordAdapter(this, words, R.color.category_colors);
        ListView list = findViewById(R.id.list);
        list.setAdapter(numberAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(colorsActivity.this, word.getAudioResource());
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(onCompletionListener);

            }
        });
    }
    @Override
   protected void onStop(){
        super.onStop();
        releaseMediaPlayer();
    }
    public void releaseMediaPlayer(){
        if(mMediaPlayer!=null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

}