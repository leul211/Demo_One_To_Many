package com.onetomany.api.one_to_many.controller;



import java.util.Optional;

import com.onetomany.api.one_to_many.exception.BookException;
import com.onetomany.api.one_to_many.model.Book;
import com.onetomany.api.one_to_many.model.Pages;
import com.onetomany.api.one_to_many.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(value = "/")
    public String testApi(){
        return "Hello User/Address api using Swagger";
    }

     @GetMapping(value = "/books")
     public Page<Book> getListOfBooks(Pageable pageable) {
         return bookService.getListOfBook(pageable);
     }

     @GetMapping(value = "/books/{id}")
     public Book findBookById(@PathVariable(value="id") long id) throws BookException{
        return bookService.bookById(id);
        }

     @PostMapping(value="/books")
     public Book saveBook(@RequestBody Book book){
         return bookService.addBook(book);
     }
}