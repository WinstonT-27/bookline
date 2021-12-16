//package com.example.demo.services;
//
//import com.example.demo.models.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class PaginationService {
//
//    @Autowired
//    private BookService bookService;
//
//    final List<Book> books = bookService.getAllBooks();
//
//    public Page<Book> findBookPagination(Pageable pageable){
//        int pageSize = pageable.getPageSize();
//        int pageNumber = pageable.getPageNumber();
//        int firstBook = pageNumber * pageSize;
//
//        List<Book> list;
//
//        if(books.size() < firstBook){
//            list = Collections.emptyList();
//        }
//        else{
//            int index = Math.min(firstBook + pageSize, books.size());
//            list = books.subList(firstBook, index);
//        }
//
//        Page<Book> bookPage = new PageImpl<Book>(list, PageRequest.of(firstBook, pageSize), books.size());
//        return bookPage;
//    }
//}
