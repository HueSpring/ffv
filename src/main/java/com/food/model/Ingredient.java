package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/4/2016.
 */
@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String name;
    private String image;
    private String unit;
    private int price;

    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private Set<FoodIngredient> foodIngredients;


    @OneToMany(mappedBy = "ingredient")
    @JsonIgnore
    private Set<ImportIngredient> importIngredients;

    public Ingredient() {
    }

    public Ingredient(String name, String image, String unit, int price) {
        this.name = name;
        this.image = image;
        this.unit = unit;
        this.price = price;
    }

    public Ingredient(String name, String image, String unit, int price, Set<FoodIngredient> foodIngredients) {
        this.name = name;
        this.image = image;
        this.unit = unit;
        this.price = price;
        this.foodIngredients = foodIngredients;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<FoodIngredient> getFoodIngredients() {
        return foodIngredients;
    }

    public void setFoodIngredients(Set<FoodIngredient> foodIngredients) {
        this.foodIngredients = foodIngredients;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
