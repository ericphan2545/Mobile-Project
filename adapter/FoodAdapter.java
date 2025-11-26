package com.midterm.foodlib.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.foodlib.R;
import com.midterm.foodlib.model.Food;
import com.midterm.foodlib.ui.DetailActivity;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<Food> foodList;
    private Context context;

    public FoodAdapter(Context context, ArrayList<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item_food.xml là file layout cho 1 dòng
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.tvName.setText(food.getName());
        holder.tvCalories.setText(food.getCalories() + " kcal");

        // Lấy ảnh từ drawable dựa trên tên
        int resId = context.getResources().getIdentifier(food.getImageResName(), "drawable", context.getPackageName());
        holder.imgFood.setImageResource(resId);

        // Xử lý click vào món ăn -> Mở màn hình Detail
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object_food", food); // Truyền cả object sang
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvCalories;
        ImageView imgFood;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ ID từ file xml item_food.xml
            tvName = itemView.findViewById(R.id.tvNameItem);
            tvCalories = itemView.findViewById(R.id.tvKcalItem);
            imgFood = itemView.findViewById(R.id.imgFoodItem);
        }
    }
}
