package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class ShowBibleTextActivity extends AppCompatActivity {
    private TextView bibleHeading;
    private TextView bibleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bible_text);

        bibleTextView = findViewById(R.id.bible_text_view);
        bibleHeading = findViewById(R.id.bible_heading);

        Intent intent = getIntent();

        bibleHeading.setText(intent.getStringExtra("bible_heading"));
        bibleTextView.setText(intent.getStringExtra("bible_text"));

    }
}