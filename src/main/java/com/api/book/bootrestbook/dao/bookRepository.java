package com.api.book.bootrestbook.dao;

import com.api.book.bootrestbook.entities.book;

import org.springframework.data.repository.CrudRepository;

public interface bookRepository extends CrudRepository<book, Integer>{
    
    public book findById(int id);
    
}
