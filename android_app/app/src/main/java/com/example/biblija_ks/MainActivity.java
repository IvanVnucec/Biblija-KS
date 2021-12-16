package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.biblija_ks.databinding.ActivityMainBinding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'biblija_ks' library on application startup.
    static {
        System.loadLibrary("biblija_ks");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        InputStream inputStream = null;
        AssetManager mngr = getAssets();
        try {
            inputStream = mngr.open("bible/Amos/Amos_-_1.html");
        } catch (final IOException e) {
            e.printStackTrace();
        }

        String result = new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n"));

        // Example of a call to a native method
        TextView tv = binding.sampleText;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            tv.setText(Html.fromHtml(result, Html.FROM_HTML_MODE_LEGACY));
        } else {
            tv.setText(Html.fromHtml(result));
        }

        // call cpp code
        //tv.setText(stringFromJNI(result));
    }

    /**
     * A native method that is implemented by the 'biblija_ks' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(String path);
}