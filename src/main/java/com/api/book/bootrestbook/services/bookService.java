package com.api.book.bootrestbook.services;

import java.util.List;
import com.api.book.bootrestbook.dao.bookRepository;
import com.api.book.bootrestbook.entities.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class bookService {
    
    @Autowired
    private bookRepository br;
    
    //commenting the demo data
   /*  private static List<book> list = new ArrayList<>();
    
    //demo data
    static{
        list.add(new book(1, "Geeta", "Krishna"));
        list.add(new book(2, "Ramayan", "Valmiki"));
        list.add(new book(3, "Mahabharat", "Vyas"));
    } */

    //get all books
    public List<book> getAlBooks(){
        List<book> list = (List<book>)this.br.findAll();
        return list;
    }

    //get single book by id
    public book getBookById(int id){
        
        book b = null;
        try{
            //b = list.stream().filter(e -> e.getId() == id).findFirst().get();
            b = this.br.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }

    //adding a book
    public book addBook(book b1){
        //list.add(b1);
        book r = br.save(b1);
        return r;
    }

    //deleting a book
    public void deleteBook(int bid){
        //list = list.stream().filter(b -> b.getId() != bid).collect(Collectors.toList());
        br.deleteById(bid);
    }

    public void updateBook(book b1, int bid){
        /* list = list.stream().map(b ->{
            if(b.getId() == bid){
                b.setTitle(b1.getTitle());
                b.setAuthor(b1.getAuthor());
            }
            return b;   
        } ).collect(Collectors.toList());
    } */
        b1.setId(bid);
        br.save(b1);
    }

}