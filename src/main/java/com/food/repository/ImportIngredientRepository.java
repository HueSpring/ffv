package com.food.repository;

import com.food.model.Import;
import com.food.model.ImportIngredient;
import com.food.model.Ingredient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Hue on 11/23/2016.
 */
public interface ImportIngredientRepository extends CrudRepository<ImportIngredient, Integer>{

    @Query("SELECT ii FROM ImportIngredient ii WHERE ii.dateEnd >= ?1 AND ii.dateEnd <= ?2")
    public Iterable<ImportIngredient> findAllEndDate(String dateCurrent, String datePlus3);

    @Query("SELECT ii FROM ImportIngredient ii WHERE ii.quantity <= 20")
    public Iterable<ImportIngredient> findAllEndQuantity();

    @Query("SELECT ii FROM ImportIngredient ii WHERE ii.dateEnd >= ?1 AND ii.quantity > 0")
    public Iterable<ImportIngredient> findAllUse(String dateCurrent);



}
