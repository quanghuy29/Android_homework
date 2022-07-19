package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello World");
        TextView textView = findViewById(R.id.text);
        textView.setBackgroundColor(getResources().getColor(R.color.black));
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setText(textView.getText().toString().toUpperCase());
    }
}