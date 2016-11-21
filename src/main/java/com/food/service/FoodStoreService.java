package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.FoodStore;
import com.food.repository.FoodStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hue on 11/12/2016.
 */
@Service
public class FoodStoreService {

    @Autowired
    private FoodStoreRepository foodStoreRepository;


    public Iterable<FoodStore> findAll(){
        return foodStoreRepository.findAll();
    }

    /**
     * find food in store
     * @param id
     * @return
     */
    public Iterable<FoodStore> findByStore(int id){
        if(!foodStoreRepository.exists(id)){
            throw new ExceptionForm("id", ExceptionForm.ERROR_CODE.EXIST, "is not exist");
        }
        return foodStoreRepository.findByStore(id);
    }
}
