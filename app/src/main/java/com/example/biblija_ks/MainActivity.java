package com.example.biblija_ks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.biblija_ks.databinding.ActivityMainBinding;

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

        String test_str = getString(R.string.test_str);

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI(test_str));
    }

    /**
     * A native method that is implemented by the 'biblija_ks' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI(String path);
}