package com.example.contacts;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EventsDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_demo);

        Button eventButton = findViewById(R.id.eventButton);
        Switch eventSwitch = findViewById(R.id.eventSwitch);
        EditText eventEditText = findViewById(R.id.eventEditText);

        // 1. OnClickListener
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventsDemoActivity.this, "Button Clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        // 2. OnLongClickListener
        eventButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(EventsDemoActivity.this, "Button Long Clicked!", Toast.LENGTH_SHORT).show();
                return true; // Return true to indicate the event is consumed
            }
        });

        // 3. OnCheckedChangeListener
        eventSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(EventsDemoActivity.this, "Switch is ON", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EventsDemoActivity.this, "Switch is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 4. TextWatcher for EditText
        eventEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used in this demo
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Show a toast with the current text
                Toast.makeText(EventsDemoActivity.this, "Text is: " + s.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used in this demo
            }
        });
    }
}