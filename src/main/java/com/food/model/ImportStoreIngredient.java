package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Hue on 11/3/2016.
 */
@Entity
@Table(name = "import_store_ingredient")
public class ImportStoreIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dateImport;
    private String dateEnd;
    private int quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user1;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_store_id")
    private User user2;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "store_ingredient_id")
    private StoreIngredient storeIngredient;


    public ImportStoreIngredient(String dateImport, String dateEnd, int quantity, StoreIngredient storeIngredient) {
        this.dateImport = dateImport;
        this.dateEnd = dateEnd;
        this.quantity = quantity;
        this.storeIngredient = storeIngredient;
    }

    public ImportStoreIngredient(String dateImport, String dateEnd, int quantity, User user1, User user2, StoreIngredient storeIngredient, User user11, User user21) {
        this.dateImport = dateImport;
        this.dateEnd = dateEnd;
        this.quantity = quantity;
        this.user1 = user1;
        this.user2 = user2;
        this.storeIngredient = storeIngredient;
        this.user1 = user11;
        this.user2 = user21;
    }

    public ImportStoreIngredient(String dateImport, String dateEnd, int quantity, User user) {
        this.dateImport = dateImport;
        this.dateEnd = dateEnd;
        this.quantity = quantity;
        this.user1 = user;
    }

    public ImportStoreIngredient(String dateImport, String dateEnd, int quantity, User user, StoreIngredient storeIngredient) {
        this.dateImport = dateImport;
        this.dateEnd = dateEnd;
        this.quantity = quantity;
        this.user1 = user;
        this.storeIngredient = storeIngredient;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateImport() {
        return dateImport;
    }

    public void setDateImport(String dateImport) {
        this.dateImport = dateImport;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user) {
        this.user1 = user;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public StoreIngredient getStoreIngredient() {
        return storeIngredient;
    }

    public void setStoreIngredient(StoreIngredient storeIngredient) {
        this.storeIngredient = storeIngredient;
    }
}
