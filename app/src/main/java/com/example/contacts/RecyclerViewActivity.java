package com.example.contacts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        // Data to display
        String[] foodList = {"Fulki", "Pani Puri", "Chawmin", "PIZZA", "MOMO", "Samosa", "Pakauda"};
        String[] foodPriceList = {"200", "300", "400", "500", "600", "700", "800"};

        // Set up RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Set the adapter
        recyclerView.setAdapter(new FoodAdapter(foodList, foodPriceList));
    }

    // Adapter class
    private static class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
        private final String[] foodList;
        private final String[] foodPriceList;

        FoodAdapter(String[] foodList, String[] foodPriceList) {
            this.foodList = foodList;
            this.foodPriceList = foodPriceList;
        }

        @NonNull
        @Override
        public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_food, parent, false);
            return new FoodViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
            holder.foodNameTextView.setText(foodList[position]);
            holder.foodPriceTextView.setText(foodPriceList[position]);
        }

        @Override
        public int getItemCount() {
            return foodList.length;
        }

        static class FoodViewHolder extends RecyclerView.ViewHolder {
            TextView foodNameTextView;
            TextView foodPriceTextView;

            FoodViewHolder(@NonNull View itemView) {
                super(itemView);
                foodNameTextView = itemView.findViewById(R.id.textViewFoodName);
                foodPriceTextView = itemView.findViewById(R.id.textViewFoodPrice);
            }
        }
    }
}