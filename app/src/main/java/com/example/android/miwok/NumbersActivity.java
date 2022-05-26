package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

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

        words.add(new word("luttie","one",R.drawable.number_one,R.raw.number_one));
        words.add(new word("otiiko","two",R.drawable.number_two,R.raw.number_two));
        words.add(new word("tolokassu","three",R.drawable.number_three,R.raw.number_three));
        words.add(new word("oyisa","four",R.drawable.number_four,R.raw.number_four));
        words.add(new word("masoka","five",R.drawable.number_five,R.raw.number_five));
        words.add(new word("temoka","six",R.drawable.number_six,R.raw.number_six));
        words.add(new word("kenakku","seven",R.drawable.number_seven,R.raw.number_seven));
        words.add(new word("kawinta","eight",R.drawable.number_eight,R.raw.number_eight));
        words.add(new word("wo'ea","nine",R.drawable.number_nine,R.raw.number_nine));
        words.add(new word("na'cha","ten",R.drawable.number_ten,R.raw.number_ten));



        wordAdapter numberAdapter = new wordAdapter(this,words,R.color.category_numbers);
        ListView list = findViewById(R.id.list);
        list.setAdapter(numberAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                word word =words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getAudioResource());
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