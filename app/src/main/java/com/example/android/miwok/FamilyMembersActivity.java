package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembersActivity extends AppCompatActivity {

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

        words.add(new word("mummy", "MOm", R.drawable.family_mother, R.raw.family_mother));
        words.add(new word("bhaiya", "brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        words.add(new word("papa", "dad", R.drawable.family_father, R.raw.family_father));
        words.add(new word("bahtijji", "nice", R.drawable.family_daughter, R.raw.family_daughter));
        words.add(new word("kaka", "uncle", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        words.add(new word("kaki", "aunty", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        words.add(new word("dadi", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        words.add(new word("dada", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));
        words.add(new word("bhabhi", "sister in law", R.drawable.family_older_sister, R.raw.family_older_sister));
        words.add(new word("bahtija", "nephew", R.drawable.family_son, R.raw.family_older_brother));


        wordAdapter numberAdapter = new wordAdapter(this, words, R.color.category_family);
        ListView list = findViewById(R.id.list);
        list.setAdapter(numberAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                word word = words.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(FamilyMembersActivity.this, word.getAudioResource());
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