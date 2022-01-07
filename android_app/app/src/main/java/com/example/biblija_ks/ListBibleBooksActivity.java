package com.example.biblija_ks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ListBibleBooksActivity extends AppCompatActivity {
    String[] sorted_bible_book_names;
    String[] sorted_bible_book_paths;
    private static final String BIBLE_DIR_PATH = "bible";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bible_books);

        sorted_bible_book_names = getResources().getStringArray(R.array.sorted_bible_book_names);
        sorted_bible_book_paths = getResources().getStringArray(R.array.sorted_bible_book_paths);

        ListView listView = findViewById(R.id.activity_list_bible_books);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, sorted_bible_book_names);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listBibleChaptersFromBook(sorted_bible_book_paths[i]);
            }

            private void listBibleChaptersFromBook(String book_path) {
                Intent intent = new Intent(getApplicationContext(), ListBibleChaptersActivity.class);

                intent.putExtra(getString(R.string.extra_book_name), book_path);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<String> getCleanBookNames(ArrayList<String> book_filenames) {
        ArrayList<String> clean_book_names = new ArrayList<>();

        for(String book_name : book_filenames) {
            clean_book_names.add(book_name.replaceAll("_", " "));
        }

        return clean_book_names;
    }

    private ArrayList<String> getBookFilenamesFromPath(String path) {
        ArrayList<String> stringList = null;

        try {
            String [] list = this.getAssets().list(path);
            stringList = new ArrayList<String>(Arrays.asList(list));
        } catch (IOException e) {
            finish();
        }

        return stringList;
    }
}