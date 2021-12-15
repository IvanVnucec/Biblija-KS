package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.biblija_ks.databinding.ActivityMainBinding;

import java.nio.charset.StandardCharsets;

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

        // TODO: Fix string encoding
        String test_str = getString(R.string.matej_5);
        byte[] bytes = test_str.getBytes(StandardCharsets.UTF_8);
        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI(utf8EncodedString));
    }

    /**
     * A native method that is implemented by the 'biblija_ks' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(String path);
}