package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.TypedValue;
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
import java.util.Map;
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

        // format row number as html superscript
        // TODO: sup style font-size does not scale down the superscript font size
        chapter_text = chapter_text
                .replaceAll("<span class=\"brojRetka\" id=\"", "<sup style=\"font-size:75%\"><span class=\"brojRetka\" id=\"")
                .replaceAll("</span>", "</span></sup>");

        // set text size
        int text_size_px = getTextSizeFromSettingsInPx();
        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, text_size_px);

        // convert text to html
        Spanned html_text;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            html_text = Html.fromHtml(chapter_text, Html.FROM_HTML_MODE_COMPACT);
        } else {
            html_text = Html.fromHtml(chapter_text);
        }

        // display html
        textView.setText(html_text);
    }
    
    private int getTextSizeFromSettingsInPx() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Map<String, ?> all = prefs.getAll();
        // TODO: fix for when user inputs non number values

        int text_size_pref;
        try {
            text_size_pref = Integer.valueOf(String.valueOf(all.get(new String("text_size"))));
        } catch (Exception e) {
            text_size_pref = (int) getResources().getDimension(R.dimen.bible_text_size_px);
        }

        return text_size_pref;
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