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
    private static final String BIBLE_DIR_PATH = "bible";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bible_books);

        ListView listView = findViewById(R.id.activity_list_bible_books);
        ArrayList<String> book_filenames = getBookFilenamesFromPath(BIBLE_DIR_PATH);
        ArrayList<String> book_names_clean = getCleanBookNames(book_filenames);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_view_row, book_names_clean);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listBibleChaptersFromBook(book_filenames.get(i));
            }

            private void listBibleChaptersFromBook(String book_name) {
                Intent intent = new Intent(getApplicationContext(), ListBibleChaptersActivity.class);

                intent.putExtra(getString(R.string.extra_book_name), book_name);
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