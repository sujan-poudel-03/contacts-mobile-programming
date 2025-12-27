package com.example.contacts;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        // Find the GridView by its ID
        GridView gridView = findViewById(R.id.gridView);

        // Define an array of items
        String[] items = {"Apple", "Banana", "Cherry", "Date", "Fig", "Grape", "Kiwi"};

        // Create and set an ArrayAdapter to the GridView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // Context
                android.R.layout.simple_list_item_1, // Layout for individual items
                items // Data source
        );
        gridView.setAdapter(adapter);

        // Handle item clicks
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the clicked item
                String item = (String) parent.getItemAtPosition(position);
                // Show a Toast message with the clicked item
                Toast.makeText(GridViewActivity.this, "Clicked: " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}