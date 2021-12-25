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
import java.util.Collections;
import java.util.Comparator;

public class ListBibleChaptersActivity extends AppCompatActivity {
    private static final String BIBLE_DIR_PATH = "bible";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bible_chapters);

        String book_name = getBookName();
        ListView listView = findViewById(R.id.activity_list_bible_chapters);
        ArrayList<String> chapter_filenames = getBibleChapterNames(book_name);
        ArrayList<String> chapter_names_clean = getCleanChapterNames(chapter_filenames);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_view_row, chapter_names_clean);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showTextFromBibleChapter(chapter_filenames.get(i));
            }

            private void showTextFromBibleChapter(String chapter) {
                Intent intent = new Intent(getApplicationContext(), ShowBibleChapterTextActivity.class);

                String chapter_path = BIBLE_DIR_PATH + '/' + book_name + '/' + chapter;
                intent.putExtra(getString(R.string.extra_chapter_path), chapter_path);
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getCleanChapterNames(ArrayList<String> chapter_filenames) {
        ArrayList<String> clean_book_names = new ArrayList<>();

        for(String book_name : chapter_filenames) {
            book_name = book_name
                    .replaceAll("_", " ")
                    .replaceAll(".html", "");
            clean_book_names.add(book_name);
        }

        return clean_book_names;
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
            finish();
        }

        return stringList;
    }
}