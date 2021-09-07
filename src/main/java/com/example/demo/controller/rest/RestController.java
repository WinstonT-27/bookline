package com.example.demo.controller.rest;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RestController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{bookTitle}")
    public List<Book> searchBook(@PathVariable String bookTitle){
        return bookService.findBook(bookTitle);
    }

}
