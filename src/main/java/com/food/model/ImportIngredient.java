package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/13/2016.
 */
@Entity
@Table(name = "import_ingredient")
public class ImportIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int quantity;
    private String dateEnd;
    private String unit;

    @ManyToOne
    @JoinColumn(name = "import_id")
    private Import anImport;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;


    @OneToMany(mappedBy = "")
    private Set<StoreIngredient> storeIngredients;


    public ImportIngredient(int quantity, String dateEnd, String unit) {
        this.quantity = quantity;
        this.dateEnd = dateEnd;
        this.unit = unit;
    }

    public ImportIngredient(int quantity, String dateEnd, String unit, Import anImport, User user, Ingredient ingredient, Set<StoreIngredient> storeIngredients) {
        this.quantity = quantity;
        this.dateEnd = dateEnd;
        this.unit = unit;
        this.anImport = anImport;
        this.user = user;
        this.ingredient = ingredient;
        this.storeIngredients = storeIngredients;
    }

    public ImportIngredient(int quantity, String dateEnd, String unit, Import anImport, Ingredient ingredient, User user, Ingredient ingredient1) {
        this.quantity = quantity;
        this.dateEnd = dateEnd;
        this.unit = unit;
        this.anImport = anImport;
        this.ingredient = ingredient;
        this.user = user;
        this.ingredient = ingredient1;
    }

    public ImportIngredient(int quantity, String dateEnd, String unit, Import anImport, Ingredient ingredient) {
        this.quantity = quantity;
        this.dateEnd = dateEnd;
        this.unit = unit;
        this.anImport = anImport;
        this.ingredient = ingredient;
    }

    public ImportIngredient(int quantity, String dateEnd, String unit, Import anImport, Ingredient ingredient, User user) {
        this.quantity = quantity;
        this.dateEnd = dateEnd;
        this.unit = unit;
        this.anImport = anImport;
        this.ingredient = ingredient;
        this.user = user;
    }

    public Set<StoreIngredient> getStoreIngredients() {
        return storeIngredients;
    }

    public void setStoreIngredients(Set<StoreIngredient> storeIngredients) {
        this.storeIngredients = storeIngredients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Import getAnImport() {
        return anImport;
    }

    public void setAnImport(Import anImport) {
        this.anImport = anImport;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
