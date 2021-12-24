package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ListBibleChaptersActivity extends AppCompatActivity {
    private static final String BIBLE_DIR_PATH = "bible";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bible_chapters);

        String book_name = getBookName();
        ListView listView = findViewById(R.id.activity_list_bible_chapters);
        ArrayList<String> templateList = getBibleChapterNames(book_name);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_view_row, templateList);
        listView.setAdapter(arrayAdapter);
    }

    private String getBookName() {
        Intent intent = getIntent();
        return intent.getStringExtra(getString(R.string.extra_book_name));
    }

    private ArrayList<String> getBibleChapterNames(String book_name) {
        ArrayList<String> stringList = null;

        try {
            String [] list = this.getAssets().list(BIBLE_DIR_PATH + '/' + book_name);
            stringList = new ArrayList<String>(Arrays.asList(list));
        } catch (IOException e) {
        }

        return stringList;
    }
}