package com.example.biblija_ks;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import java.util.Map;

public class ScreenSlidePageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View root_view =
                inflater.inflate(R.layout.fragment_screen_slide_page, container, false);

        TextView text_view = root_view.findViewById(R.id.chapter_text);
        String chapter_text = getArguments().getString(getString(R.string.chapter_text));
        int chapter_text_size = getArguments().getInt(getString(R.string.chapter_text_size_in_px));
        writeChapterTextToTextView(text_view, chapter_text, chapter_text_size);

        return root_view;
    }

    private void writeChapterTextToTextView(TextView textView, String chapter_text, int text_size_px) {
        // format row number as html superscript
        // TODO: sup style font-size does not scale down the superscript font size
        chapter_text = chapter_text
                .replaceAll("<span class=\"brojRetka\" id=\"", "<sup style=\"font-size:75%\"><span class=\"brojRetka\" id=\"")
                .replaceAll("</span>", "</span></sup>");

        // set text size
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
}
