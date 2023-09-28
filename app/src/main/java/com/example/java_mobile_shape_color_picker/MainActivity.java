package com.example.java_mobile_shape_color_picker;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ImageView imageView;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;

    private TextView redTextView;
    private TextView greenTextView;
    private TextView blueTextView;

    private int redValue = 0;
    private int greenValue = 0;
    private int blueValue = 0;

    private void changeColor() {
        int color = Color.rgb(redValue, greenValue, blueValue);
        imageView.setColorFilter(color);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);
        redSeekBar = findViewById(R.id.seekBar);
        greenSeekBar = findViewById(R.id.seekBar2);
        blueSeekBar = findViewById(R.id.seekBar3);
        redTextView = findViewById(R.id.R);
        greenTextView = findViewById(R.id.G);
        blueTextView = findViewById(R.id.B);

        redSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                redValue = progress;
                redTextView.setText(String.valueOf(progress));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        greenSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                greenValue = progress;
                greenTextView.setText(String.valueOf(progress));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        blueSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blueValue = progress;
                blueTextView.setText(String.valueOf(progress));
                changeColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected = spinner.getSelectedItem().toString();
                int drawableResourceId = getResources().getIdentifier(selected, "drawable", getPackageName());
                imageView.setImageResource(drawableResourceId);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Handle nothing selected if needed
            }
        });
    }
}
