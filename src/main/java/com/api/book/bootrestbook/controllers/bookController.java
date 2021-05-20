package com.api.book.bootrestbook.controllers;

import java.util.List;

import com.api.book.bootrestbook.entities.book;
import com.api.book.bootrestbook.services.bookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class bookController {
    
    @Autowired
    private bookService bs;

    @GetMapping("/books")
    public List<book> getBooks(){
        return this.bs.getAlBooks();
    }

    @GetMapping("/books/{id}")
    public book getBook(@PathVariable("id") int id){
        return bs.getBookById(id);
    }

    @PostMapping(value="/books")
    public book addBook(@RequestBody book b1) {
        book b2 = this.bs.addBook(b1);
        System.out.println(b2);
        return b2;
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id){
        this.bs.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public book updateBook(@RequestBody book b, @PathVariable("id") int id){
        this.bs.updateBook(b, id);
        return b;
    }
    
}
