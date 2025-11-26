package com.midterm.foodlib;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.foodlib.adapter.FoodAdapter;
import com.midterm.foodlib.model.Food;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvFood;
    ArrayList<Food> foodList;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvFood = findViewById(R.id.rcvFood);
        foodList = new ArrayList<>();

        // Tạo dữ liệu mẫu: Cơm gà Hội An
        ArrayList<String> nguyenLieu = new ArrayList<>(Arrays.asList("1 bát gạo", "150g ức gà", "Rau thơm, hành"));
        ArrayList<String> cacBuoc = new ArrayList<>(Arrays.asList("1. Luộc gà", "2. Nấu cơm bằng nước luộc", "3. Xé gà trộn gia vị"));

        foodList.add(new Food("Cơm gà Hội An", "img_comga", 650, "Món chính", "40 phút", "1 người", 32, 70, 20, nguyenLieu, cacBuoc));

        // Thêm các món khác tương tự...
        foodList.add(new Food("Phở bò Hà Nội", "img_phobo", 550, "Món nước", "30 phút", "1 người", 25, 60, 15, nguyenLieu, cacBuoc));

        adapter = new FoodAdapter(this, foodList);
        rcvFood.setLayoutManager(new LinearLayoutManager(this));
        rcvFood.setAdapter(adapter);
    }
}