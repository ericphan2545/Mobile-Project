package com.midterm.foodlib.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.midterm.foodlib.R;
import com.midterm.foodlib.model.Food;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        // Nhận dữ liệu từ Intent
        Food food = (Food) getIntent().getSerializableExtra("object_food");

        // Ánh xạ View
        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvType = findViewById(R.id.tvType);
        TextView tvCalories = findViewById(R.id.tvDetailKcal);
        ImageView imgDetail = findViewById(R.id.imgDetail);
        Button btnViewRecipe = findViewById(R.id.btnViewRecipe);

        // Hiển thị dữ liệu
        if (food != null) {
            tvName.setText(food.getName());
            tvType.setText("Loại: " + food.getType());
            tvCalories.setText(food.getCalories() + " kcal");

            int resId = getResources().getIdentifier(food.getImageResName(), "drawable", getPackageName());
            imgDetail.setImageResource(resId);

            // Xử lý nút "Xem công thức" -> Sang màn 3
            btnViewRecipe.setOnClickListener(v -> {
                Intent intent = new Intent(DetailActivity.this, RecipeActivity.class);
                intent.putExtra("object_food_recipe", food); // Tiếp tục truyền object sang màn 3
                startActivity(intent);
            });
        }
    }
}