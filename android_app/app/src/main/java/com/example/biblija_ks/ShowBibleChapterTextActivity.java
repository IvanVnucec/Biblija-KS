package com.example.biblija_ks;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.TypedValue;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;


public class ShowBibleChapterTextActivity extends FragmentActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private int num_of_chapters;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private FragmentStateAdapter pagerAdapter;

    private ArrayList<String> chapter_texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_slide);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);

        Intent intent = getIntent();
        ArrayList<String> chapter_paths = getChapterPaths(intent);
        chapter_texts = getChapterTexts(chapter_paths);
        num_of_chapters = chapter_paths.size();

        int wanted_chapter_index = getWantedChapterIndex(intent);
        viewPager.setCurrentItem(wanted_chapter_index, false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();

            // send chapter text to the fragment
            Bundle bundle = new Bundle();
            bundle.putString(getString(R.string.chapter_text), chapter_texts.get(position));
            bundle.putInt(getString(R.string.chapter_text_size_in_px), getTextSizeFromSettingsInPx());
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public int getItemCount() {
            return num_of_chapters;
        }
    }

    private ArrayList<String> getChapterTexts(ArrayList<String> chapter_paths) {
        ArrayList<String> texts = new ArrayList<>();

        for (String chapter_path : chapter_paths)
            texts.add(readTextFromFile(chapter_path));

        return texts;
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

    private ArrayList<String> getChapterPaths(Intent intent) {
        return intent.getStringArrayListExtra(getString(R.string.extra_chapter_path));
    }

    private int getWantedChapterIndex(Intent intent) {
        return intent.getIntExtra(getString(R.string.wanted_chapter_index), 0);
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
}
