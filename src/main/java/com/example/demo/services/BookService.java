package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findBook(String bookTitle){
        return bookRepository.findByBookTitle(bookTitle);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAllBy();
    }

    public void createBookIndexBulk(final List<Book> books){
        bookRepository.saveAll(books);
    }

    public void deleteBook(String bookTitle){
        bookRepository.deleteBookByBookTitle(bookTitle);
    }

    public List<Book> updateBook(Book book){
        bookRepository.deleteBookByBookTitle(book.getBookTitle());
        List<Book> newBook = new ArrayList<>();
        newBook.add(book);
        createBookIndexBulk(newBook);

        return findBook(book.getBookTitle());
    }
}
