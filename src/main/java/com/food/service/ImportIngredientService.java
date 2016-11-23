package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.ImportIngredient;
import com.food.repository.ImportIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * Created by Hue on 11/14/2016.
 */
@Service
public class ImportIngredientService {

    public final Long DAY_MAX = 3L;

    @Autowired
    private ImportIngredientRepository importIngredientRepository;


    public Iterable<ImportIngredient> findAll() {
        Iterable<ImportIngredient> list = importIngredientRepository.findAll();
        if (list == null) {
            throw new ExceptionForm("import ingredient", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<ImportIngredient> findAllEndDate() {
        Date date = new Date();
        return importIngredientRepository.findAllEndDate(Common.dateToString(date), Common.parseArrayInt(date, DAY_MAX));
    }

    public Iterable<ImportIngredient> findAllEndQuantity(){
        return importIngredientRepository.findAllEndQuantity();
    }

    public Iterable<ImportIngredient> findAllUse(){
        Date date = new Date();
        return importIngredientRepository.findAllUse(Common.dateToString(date));
    }

}
