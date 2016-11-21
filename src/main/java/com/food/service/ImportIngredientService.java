package com.food.service;

import com.food.exception.ExceptionForm;
import com.food.model.ImportIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by Hue on 11/14/2016.
 */
@Service
public class ImportIngredientService {

    @Autowired
    private ImportIngredientService importIngredientService;


    public Iterable<ImportIngredient> findAll(){
        Iterable<ImportIngredient> list = importIngredientService.findAll();
        if(list == null){
            throw new ExceptionForm("import ingredient", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }





}
