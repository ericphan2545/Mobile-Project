package com.midterm.foodlib.ui;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.midterm.foodlib.R;
import com.midterm.foodlib.model.Food;

public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Food food = (Food) getIntent().getSerializableExtra("object_food_recipe");

        TextView tvIngredients = findViewById(R.id.tvIngredientsList);
        TextView tvSteps = findViewById(R.id.tvStepsList);
        TextView tvTitle = findViewById(R.id.tvRecipeTitle);

        if (food != null) {
            tvTitle.setText(food.getName());

            // Hiển thị Nguyên liệu (nối các dòng lại với nhau)
            StringBuilder builderIng = new StringBuilder();
            for (String item : food.getIngredients()) {
                builderIng.append("- ").append(item).append("\n");
            }
            tvIngredients.setText(builderIng.toString());

            // Hiển thị Các bước
            StringBuilder builderSteps = new StringBuilder();
            for (String step : food.getSteps()) {
                builderSteps.append(step).append("\n\n");
            }
            tvSteps.setText(builderSteps.toString());
        }
    }
}
