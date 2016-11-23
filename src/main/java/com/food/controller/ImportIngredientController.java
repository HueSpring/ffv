package com.food.controller;

import com.food.model.ImportIngredient;
import com.food.service.ImportIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hue on 11/23/2016.
 */
@RestController
@RequestMapping(value = "/{key}/ingredient/import")
public class ImportIngredientController {

    @Autowired
    private ImportIngredientService importIngredientService;

    @RequestMapping(value = "/day-end", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllEndDate(){
        return importIngredientService.findAllEndDate();
    }

    @RequestMapping(value = "/quantity-end", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllEndQuantity(){
        return importIngredientService.findAllEndQuantity();
    }

    @RequestMapping(value = "/use", method = RequestMethod.GET)
    public Iterable<ImportIngredient> findAllUse(){
        return importIngredientService.findAllUse();
    }

}
