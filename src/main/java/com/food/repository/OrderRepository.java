package com.food.repository;

import com.food.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Hue on 11/15/2016.
 */
@Transactional
public interface OrderRepository extends CrudRepository<Book, String> {

    @Query("SELECT o FROM Book o WHERE o.status = true")
    public Iterable<Book> findAllStatus();


    @Query("SELECT o FROM Book o WHERE o.status = false")
    public Iterable<Book> findAllNoStatus();

}
