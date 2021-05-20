package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.api.book.bootrestbook.entities.book;

import org.springframework.stereotype.Component;

@Component
public class bookService {
    
    private static List<book> list = new ArrayList<>();
    static{
        list.add(new book(1, "Geeta", "Krishna"));
        list.add(new book(2, "Ramayan", "Valmiki"));
        list.add(new book(3, "Mahabharat", "Vyas"));
    }

    public List<book> getAlBooks(){
        return list;
    }

    public book getBookById(int id){
        
        book b = null;
        try{
            b = list.stream().filter(e -> e.getId() == id).findFirst().get();
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    public book addBook(book b1){
        list.add(b1);
        return b1;
    }

    public void deleteBook(int bid){
        list = list.stream().filter(b -> b.getId() != bid).collect(Collectors.toList());
        
    }

    public void updateBook(book b1, int bid){
        list = list.stream().map(b ->{
            if(b.getId() == bid){
                b.setTitle(b1.getTitle());
                b.setAuthor(b1.getAuthor());
            }
            return b;   
        } ).collect(Collectors.toList());
    }
}
