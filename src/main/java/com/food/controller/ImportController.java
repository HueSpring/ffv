package com.food.controller;

import com.food.model.Import;
import com.food.service.ImportService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hue on 11/13/2016.
 */
@RestController
@RequestMapping(value = "/{key}/import")
public class ImportController {

    @Autowired
    private ImportService importService;

    @Autowired
    private PermissionService permissionService;

    public ImportController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Import> findAll(@PathVariable(value = "key") String key) {
        permissionService.permission(permissionService.INGREDIENT_VIEW, key);
        return importService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Import findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.INGREDIENT_VIEW, key);
        return importService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Import save(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.INGREDIENT_ADD, key);
        return importService.save();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable(value = "key") String key, @PathVariable(value = "id") int id){
        permissionService.permission(permissionService.INGREDIENT_DELETE, key);
        return importService.delete(id);
    }


}
