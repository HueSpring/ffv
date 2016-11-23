package com.food.repository;

import com.food.model.StoreIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/23/2016.
 */
@Transactional
public interface StoreIngredientRepository extends CrudRepository<StoreIngredient, Integer> {



}
