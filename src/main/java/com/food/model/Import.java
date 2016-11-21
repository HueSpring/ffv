package com.food.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hue on 11/13/2016.
 */
@Entity
@Table(name = "import")
public class Import {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dateImport;

    @OneToMany(mappedBy = "anImport")
    @JsonIgnore
    private Set<ImportIngredient> importIngredients;

    public Import() {
    }

    public Import(String dateImport) {
        this.dateImport = dateImport;
    }

    public Import(String dateImport, Set<ImportIngredient> importIngredients) {
        this.dateImport = dateImport;
        this.importIngredients = importIngredients;
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

    public Set<ImportIngredient> getImportIngredients() {
        return importIngredients;
    }

    public void setImportIngredients(Set<ImportIngredient> importIngredients) {
        this.importIngredients = importIngredients;
    }
}
