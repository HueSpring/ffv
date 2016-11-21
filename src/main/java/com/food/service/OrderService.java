package com.food.service;

import com.food.common.Common;
import com.food.exception.ExceptionForm;
import com.food.model.*;
import com.food.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hue on 11/15/2016.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderTypeRepository orderTypeRepository;

    public OrderService() {
    }

    public Iterable<Book> findAll() {
        Iterable<Book> list = orderRepository.findAll();
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<Book> findAllNoStatus(){
        Iterable<Book> list = orderRepository.findAllNoStatus();
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Iterable<Book> findAllStatus(){
        Iterable<Book> list = orderRepository.findAllStatus();
        if (list == null) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Not found");
        }
        return list;
    }

    public Book findOne(String id) {
        if (!orderRepository.exists(id)) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Order is not exist");
        }
        return orderRepository.findOne(id);
    }


    public Book save(String idCustomer, String address, int orderTypeId) {
        if (orderRepository.exists(idCustomer)) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Order is already exist");
        }
        OrderType orderType = orderTypeRepository.findOne(orderTypeId);
        Date date = new Date();
        String dateCreated = Common.dateTimeToString(date);
        String idOrder = Common.splitDateTime(date)  + orderRepository.count();
        Book order = new Book(idOrder, address, false, dateCreated, orderType);
        return orderRepository.save(order);
    }


    /**
     * use for pay bill
     * @param id
     * @return
     */
    public Book update(String id){
        if (orderRepository.exists(id)) {
            throw new ExceptionForm("Order", ExceptionForm.ERROR_CODE.EXIST, "Order is already exist");
        }
        Book order = orderRepository.findOne(id);
        Date date = new Date();
        String dateBill = Common.dateTimeToString(date);
        order.setDateOrder(dateBill);
        order.setStatus(true);
        return order;
    }


    public ResponseEntity<String> delete(String id) {
        if (!orderRepository.exists(id)) {
            throw new ExceptionForm("order", ExceptionForm.ERROR_CODE.EXIST, "Order is not exist");
        }
        orderRepository.delete(id);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }


}
