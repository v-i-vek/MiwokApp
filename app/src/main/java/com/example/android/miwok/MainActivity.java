package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView Numbers,Family,Colors,Phrases;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Numbers = findViewById(R.id.numbers);
        Numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNumberList();
            }
        });

        Family = findViewById(R.id.family);
        Family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFamily();
            }
        });
        Colors = findViewById(R.id.colors);
        Colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColors();
            }
        });
        Phrases = findViewById(R.id.phrases);
        Phrases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPhrases();
            }
        });
    }

    private void openPhrases() {
        Intent P = new Intent(this,PhrasesActivity.class);
        startActivity(P);

      }

    private void openColors() {
        Intent c = new Intent(this,colorsActivity.class);
        startActivity(c);
    }

    private void openFamily() {
        Intent f = new Intent(this,FamilyMembersActivity.class);
        startActivity(f);
    }

    private void openNumberList() {
        Intent n = new Intent(this,NumbersActivity.class);
        startActivity(n);
    }
}