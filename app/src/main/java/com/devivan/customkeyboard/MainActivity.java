package com.devivan.customkeyboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.devivan.customkeyboard.keyboards.CustomKeyboard;
import com.devivan.customkeyboard.keyboards.CustomKeyboardWithRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView textView, textViewWithRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Custom keyboard
        textView = findViewById(R.id.textView);
        textView.setOnClickListener(v -> new CustomKeyboard(this, textView, true).show());
        //textView.performClick();
        //////////////////////////

        // Custom keyboard with recycler view
        textViewWithRecyclerView = findViewById(R.id.textViewWithRecyclerView);
        textViewWithRecyclerView.setOnClickListener(v -> new CustomKeyboardWithRecyclerView(this, textViewWithRecyclerView, true, getListOfNames()).show());
        textViewWithRecyclerView.performClick();
        ////////////////////////////////////////
    }

    public ArrayList<String> getListOfNames() {
        return new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.names)));
    }
}