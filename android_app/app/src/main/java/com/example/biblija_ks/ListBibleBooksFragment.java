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

import com.example.biblija_ks.R;
import com.example.biblija_ks.databinding.FragmentListBibleBooksBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ListBibleBooksFragment extends Fragment {

    private FragmentListBibleBooksBinding binding;
    private static final String BIBLE_DIR_PATH = "bible";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentListBibleBooksBinding.inflate(inflater, container, false);

        ListView listView = binding.getRoot().findViewById(R.id.mobile_list);

        ArrayList<String> book_filenames = getBookFilenamesFromPath(BIBLE_DIR_PATH);
        ArrayList<String> book_names_clean = getCleanBookNames(book_filenames);

        ArrayAdapter<String> allItemsAdapter = new ArrayAdapter<>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, book_names_clean);
        listView.setAdapter(allItemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Bundle bundle = new Bundle();
                bundle.putString(getString(R.string.extra_book_name), book_filenames.get(i));

                NavHostFragment.findNavController(ListBibleBooksFragment.this)
                        .navigate(R.id.action_ListBibleBooksFragment_to_ListBibleChaptersFragment, bundle);
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
            String [] list = getActivity().getAssets().list(path);
            stringList = new ArrayList<>(Arrays.asList(list));
        } catch (IOException e) {
            getActivity().finish();
        }

        return stringList;
    }

}