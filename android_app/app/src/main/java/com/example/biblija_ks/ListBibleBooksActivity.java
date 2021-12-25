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

public class ListBibleBooksActivity extends AppCompatActivity {
    private static final String BIBLE_DIR_PATH = "bible";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_bible_books);

        ListView listView = findViewById(R.id.activity_list_bible_books);
        ArrayList<String> book_names = getBibleBookNames();

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.list_view_row, book_names);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listBibleChaptersFromBook(book_names.get(i));
            }

            private void listBibleChaptersFromBook(String book_name) {
                Intent intent = new Intent(getApplicationContext(), ListBibleChaptersActivity.class);

                intent.putExtra(getString(R.string.extra_book_name), book_name);
                startActivity(intent);
            }
        });
    }

    private ArrayList<String> getBibleBookNames() {
        ArrayList<String> stringList = null;

        try {
            String [] list = this.getAssets().list(BIBLE_DIR_PATH);
            stringList = new ArrayList<String>(Arrays.asList(list));
        } catch (IOException e) {
        }

        return stringList;
    }
}