package com.onetomany.api.one_to_many.service;

import com.onetomany.api.one_to_many.exception.BookException;
import com.onetomany.api.one_to_many.model.Book;
import com.onetomany.api.one_to_many.repository.BookRepository;
import com.onetomany.api.one_to_many.model.Pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    //POST all users 
    //TODO GET list of all users.
    public Page<Book> getListOfBook(Pageable pageable){
       
        return bookRepository.findAll(pageable);
    }

    public Book bookById(long id) throws BookException {
        return bookRepository.findById(id).orElseThrow(()-> new BookException("Book not found by the id: "+id));
    }

    //POST Single user only
    public Book addBook(Book book){
        return bookRepository.save(book);
    }


}