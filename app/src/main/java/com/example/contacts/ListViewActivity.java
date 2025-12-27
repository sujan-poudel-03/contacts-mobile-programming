package com.example.contacts;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Find the ListView by its ID
        ListView listView = findViewById(R.id.listView);

        // Define an array of items
        String[] food_listItem = {"Fulki", "Pani Puri", "Chawmin", "PIZZA", "MOMO", "Samosa", "Pakauda"};

        // Create and set an ArrayAdapter to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // Context
                android.R.layout.simple_list_item_1, // Layout for individual items
                food_listItem // Data source
        );

        listView.setAdapter(adapter);

        // Handle item clicks
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the clicked item
                String item = (String) parent.getItemAtPosition(position);
                // Show a Toast message with the clicked item
                Toast.makeText(ListViewActivity.this, "Clicked: " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}