package com.midterm.foodlib.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Food implements Serializable {
    private String name;
    private String imageResName; // Tên file ảnh trong drawable (vd: "com_ga")
    private int calories;
    private String type;         // Vd: "Món chính"
    private String time;         // Vd: "40 phút"
    private String servings;     // Vd: "1 người"
    private int protein, carbs, fat;
    private ArrayList<String> ingredients; // Danh sách nguyên liệu
    private ArrayList<String> steps;       // Các bước nấu

    // Constructor
    public Food(String name, String imageResName, int calories, String type, String time, String servings, int protein, int carbs, int fat, ArrayList<String> ingredients, ArrayList<String> steps) {
        this.name = name;
        this.imageResName = imageResName;
        this.calories = calories;
        this.type = type;
        this.time = time;
        this.servings = servings;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
        this.ingredients = ingredients;
        this.steps = steps;
    }

    // Getter methods (Bắt buộc để lấy dữ liệu ra)
    public String getName() { return name; }
    public String getImageResName() { return imageResName; }
    public int getCalories() { return calories; }
    public String getType() { return type; }
    public String getTime() { return time; }
    public String getServings() { return servings; }
    public int getProtein() { return protein; }
    public int getCarbs() { return carbs; }
    public int getFat() { return fat; }
    public ArrayList<String> getIngredients() { return ingredients; }
    public ArrayList<String> getSteps() { return steps; }
}
