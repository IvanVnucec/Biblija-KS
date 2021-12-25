package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ShowBibleChapterTextActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bible_chapter_text);

        String chapter_path = getChapterPath();
        String chapter_text = getChapterText(chapter_path);
        writeChapterTextToTextView(chapter_text);
    }

    private void writeChapterTextToTextView(String chapter_text) {
        TextView textView = findViewById(R.id.bible_chapter_text);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(chapter_text, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(chapter_text));
        }
    }

    private String getChapterText(String chapter_path) {
        String text = readTextFromFile(chapter_path);
        return text;
    }

    private String readTextFromFile(String filepath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open(filepath)));
            StringBuilder out= new StringBuilder();
            String each_line = bufferedReader.readLine();
            while (each_line != null) {
                out.append(each_line);
                each_line = bufferedReader.readLine();
            }
            return out.toString();
        } catch (IOException e) {
        }

        return null;
    }

    private String getChapterPath() {
        Intent intent = getIntent();
        return intent.getStringExtra(getString(R.string.extra_chapter_path));
    }
}