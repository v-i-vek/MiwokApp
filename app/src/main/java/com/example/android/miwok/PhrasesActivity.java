package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
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

        words.add(new word("kya kar rahi ho ?", "what are you doing?", R.raw.phrase_come_here));
        words.add(new word("kahan ja rahi ho?", "where are you going", R.raw.phrase_are_you_coming));
        words.add(new word("tumhara nam kya hai ?", "what is your name?", R.raw.phrase_how_are_you_feeling));
        words.add(new word("kaise ho", "how are you?", R.raw.phrase_im_feeling_good));
        words.add(new word("kahn padti ho ?", "where do you study", R.raw.phrase_im_coming));
        words.add(new word("tumhare papa ka name kya hai ?", "what is the name of you father", R.raw.phrase_lets_go));
        words.add(new word("tum kitne saal ke ho", "how old are you", R.raw.phrase_lets_go));
        words.add(new word("kahan rehte ho", "where do you live", R.raw.phrase_what_is_your_name));
        words.add(new word("diwali kab hai", "when is diwali", R.raw.phrase_where_are_you_going));
        words.add(new word("tum kab jaoge", "when will you go", R.raw.phrase_yes_im_coming));


        wordAdapter numberAdapter = new wordAdapter(PhrasesActivity.this, words, R.color.category_phrases);
        ListView list = findViewById(R.id.list);
        list.setAdapter(numberAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudioResource());
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