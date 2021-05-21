package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.bootrestbook.entities.book;
import com.api.book.bootrestbook.services.bookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class bookController {
    
    @Autowired
    private bookService bs;

    //GET all books
    @GetMapping("/books")
    public ResponseEntity<List<book>> getBooks(){
        
        List<book> list = this.bs.getAlBooks();
        if(list.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    //GET a single book using id
    @GetMapping("/books/{id}")
    public ResponseEntity<book> getBook(@PathVariable("id") int id){
        book b = bs.getBookById(id);
        if(b == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    //adding a book
    @PostMapping(value="/books")
    public ResponseEntity<book> addBook(@RequestBody book b1) {
        book b2 = null;
        try{
            b2 = this.bs.addBook(b1);
            System.out.println(b2);
            return ResponseEntity.of(Optional.of(b2));
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    //delete a book
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
        try{
            this.bs.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
   }

   //update the book
    @PutMapping("/books/{id}")
    public ResponseEntity<book> updateBook(@RequestBody book b, @PathVariable("id") int id){
        try{
            this.bs.updateBook(b, id);
            return ResponseEntity.ok().body(b);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}