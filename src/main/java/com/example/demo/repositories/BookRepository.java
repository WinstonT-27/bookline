package com.example.demo.repositories;

import com.example.demo.models.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findByBookTitle(String bookTitle);

    List<Book> findBookByBookAuthor(String bookAuthor);

    List<Book> findBookByBookCategory(String bookCategory);

    List<Book> findBookByBookTitleOrBookAuthor(String bookTitle, String bookAuthor);

    List<Book> findBookByBookTitleContaining(String searchQuery);

    void deleteBookByBookTitle(String bookTitle);

    List<Book> findAllBy();

}
