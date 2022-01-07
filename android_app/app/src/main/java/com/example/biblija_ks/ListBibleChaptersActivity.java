package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListBibleChaptersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bible_chapters);

        Intent intent = getIntent();
        String book_path = getBookPath(intent);
        ListView listView = findViewById(R.id.activity_list_bible_chapters);
        ArrayList<String> chapter_filenames = getBibleChapterNames(book_path);
        ArrayList<String> chapter_names = getChapterNames(chapter_filenames.size());

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chapter_names);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showTextFromBibleChapters(chapter_filenames, i);
            }

            private void showTextFromBibleChapters(ArrayList<String> chapters, int wanted_chapter_index) {
                ArrayList<String> chapter_paths = new ArrayList<>();
                for (String chapter : chapters)
                    chapter_paths.add(book_path + '/' + chapter);

                Intent intent = new Intent(getApplicationContext(), ShowBibleChapterTextActivity.class);
                intent.putExtra(getString(R.string.extra_chapter_path), chapter_paths);
                intent.putExtra(getString(R.string.wanted_chapter_index), wanted_chapter_index);
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getChapterNames(int size) {
        ArrayList<String> chapter_names = new ArrayList<>(size);

        for(int i=0; i<size; i++) {
            chapter_names.add("Glava " + i);
        }

        return chapter_names;
    }

    private String getBookPath(Intent intent) {
        return intent.getStringExtra(getString(R.string.extra_book_name));
    }

    private ArrayList<String> getBibleChapterNames(String book_path) {
        ArrayList<String> chapter_names = null;

        try {
            String [] list = this.getAssets().list(book_path);
            chapter_names = new ArrayList<String>(Arrays.asList(list));
        } catch (IOException e) {
            finish();
        }

        Comparator<? super String> ascending_comparator = new Comparator<String>() {
            public int compare(String name1, String name2) {
                int num1 = Integer.parseInt(name1.replaceAll("[^0-9]", ""));
                int num2 = Integer.parseInt(name2.replaceAll("[^0-9]", ""));
                // > : Increasing order
                // < : Decreasing order
                if(num1 > num2)
                    return 1;
                else
                    return -1;
            }
        };

        Collections.sort(chapter_names, ascending_comparator);

        return chapter_names;
    }
}