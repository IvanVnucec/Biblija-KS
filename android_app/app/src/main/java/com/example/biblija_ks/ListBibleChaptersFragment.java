package com.example.biblija_ks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.biblija_ks.databinding.FragmentListBibleChaptersBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ListBibleChaptersFragment extends Fragment {

    private FragmentListBibleChaptersBinding binding;
    private static final String BIBLE_DIR_PATH = "bible";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentListBibleChaptersBinding.inflate(inflater, container, false);

        ListView listView = binding.getRoot().findViewById(R.id.list_view_bible_chapters);

        Bundle bundle = getArguments();
        String book_name = getBookName(bundle);
        ArrayList<String> chapter_filenames = getBibleChapterNames(book_name);
        ArrayList<String> chapter_names_clean = getCleanChapterNames(chapter_filenames);

        ArrayAdapter<String> allItemsAdapter = new ArrayAdapter<>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, chapter_names_clean);
        listView.setAdapter(allItemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                ArrayList<String> chapter_paths = new ArrayList<>();
                for (String chapter : chapter_filenames)
                    chapter_paths.add(BIBLE_DIR_PATH + '/' + book_name + '/' + chapter);

                // TODO: send data to the MainActivity
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(getString(R.string.extra_chapter_path), chapter_paths);
                bundle.putInt(getString(R.string.wanted_chapter_index), i);

                NavHostFragment.findNavController(ListBibleChaptersFragment.this)
                        .navigate(R.id.action_ListBibleChaptersFragment_to_screenSlidePageFragment, bundle);
            }
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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

    private String getBookName(Bundle bundle) {
        return bundle.getString(getString(R.string.extra_book_name));
    }

    private ArrayList<String> getBibleChapterNames(String book_name) {
        ArrayList<String> chapter_names = null;

        try {
            String [] list = getActivity().getAssets().list(BIBLE_DIR_PATH + '/' + book_name);
            chapter_names = new ArrayList<String>(Arrays.asList(list));
        } catch (IOException e) {
            getActivity().finish();
        }

        Comparator<? super String> ascending_comparator = new Comparator<String>() {
            public int compare(String name1, String name2) {
                int num1 = new Scanner(name1).useDelimiter("\\D+").nextInt();
                int num2 = new Scanner(name2).useDelimiter("\\D+").nextInt();
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