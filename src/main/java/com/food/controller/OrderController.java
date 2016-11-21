package com.food.controller;

import com.food.model.Book;
import com.food.service.OrderService;
import com.food.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Hue on 11/15/2016.
 */
@RestController
@RequestMapping(value = "/{key}/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PermissionService permissionService;

    public OrderController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> findAll(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAll();
    }


    @RequestMapping(value = "/done", method = RequestMethod.GET)
    public Iterable<Book> findAllStatus(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAllStatus();
    }

    @RequestMapping(value = "/non", method = RequestMethod.GET)
    public Iterable<Book> findAllNoStatus(@PathVariable(value = "key") String key){
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findAllNoStatus();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book findOne(@PathVariable(value = "key") String key, @PathVariable(value = "id") String id){
        permissionService.permission(permissionService.ORDER_VIEW, key);
        return orderService.findOne(id);
    }




}
