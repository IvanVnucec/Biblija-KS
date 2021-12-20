package com.example.biblija_ks.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.biblija_ks.R;
import com.example.biblija_ks.ShowBibleTextActivity;
import com.example.biblija_ks.databinding.FragmentSlideshowBinding;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = binding.listview;
        String bible_path = getString(R.string.bible_path);
        final ArrayList<String> files = listAssetFiles(bible_path);

        ArrayList<String> bible_book_names = new ArrayList<String>();
        for (String file : files) {
            String book_name = file.replaceAll("_", " ");
            bible_book_names.add(book_name);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, bible_book_names);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ShowBibleTextActivity.class);

                // TODO: get text from bible chapter
                String bible_text = "TODO: put bible text here";
                intent.putExtra("bible_heading", bible_book_names.get(i));
                intent.putExtra("bible_text", "TODO: Get text here");
                startActivity(intent);
            }
        });

        return root;
    }

    private ArrayList<String> listAssetFiles(String path) {
        ArrayList<String> stringList = null;

        try {
            String [] list = this.getActivity().getAssets().list(path);
            stringList = new ArrayList<String>(Arrays.asList(list));
        } catch (IOException e) {
        }

        return stringList;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}