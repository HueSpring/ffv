package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/3/2016.
 */
@Entity
@Table(name = "store_ingredient")
public class StoreIngredient {

    @Id
    @GeneratedValue
    private String id;
    private int quantity;
    private String unit;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "storeIngredient")
    private Set<ImportStoreIngredient> importStoreIngredients;

    @ManyToOne
    @JoinColumn(name = "import_ingredient_id")
    private ImportIngredient importIngredient;

    public StoreIngredient() {
    }

    public StoreIngredient(int quantity, String unit, Store store) {
        this.quantity = quantity;
        this.unit = unit;
        this.store = store;
    }

    public StoreIngredient(int quantity, String unit, Store store, Set<ImportStoreIngredient> importStoreIngredients) {
        this.quantity = quantity;
        this.unit = unit;
        this.store = store;
        this.importStoreIngredients = importStoreIngredients;
    }

    public StoreIngredient(int quantity, String unit, Store store, ImportIngredient importIngredient) {
        this.quantity = quantity;
        this.unit = unit;
        this.store = store;
        this.importIngredient = importIngredient;
    }

    public StoreIngredient(int quantity, String unit, Store store, Set<ImportStoreIngredient> importStoreIngredients, ImportIngredient importIngredient) {
        this.quantity = quantity;
        this.unit = unit;
        this.store = store;
        this.importStoreIngredients = importStoreIngredients;
        this.importIngredient = importIngredient;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Set<ImportStoreIngredient> getImportStoreIngredients() {
        return importStoreIngredients;
    }

    public void setImportStoreIngredients(Set<ImportStoreIngredient> importStoreIngredients) {
        this.importStoreIngredients = importStoreIngredients;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ImportIngredient getImportIngredient() {
        return importIngredient;
    }

    public void setImportIngredient(ImportIngredient importIngredient) {
        this.importIngredient = importIngredient;
    }
}
