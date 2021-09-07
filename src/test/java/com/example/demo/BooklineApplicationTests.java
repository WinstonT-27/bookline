package com.example.demo;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class BooklineApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
    }

    @Test
    public void getAllBooksTest(){
        System.out.println(bookService.getAllBooks());
    }

    @Test
    public void deleteBook(){
        bookService.deleteBook("Bookx");

        System.out.println("##" + bookService.findBook("Book"));
    }

    @Test
    public void addBooksToElasticTest(){

        Book book1 = Book.builder()
                .bookTitle("Book")
                .bookAuthor("Mr Author")
                .bookCategory("Fiction")
                .bookDescription("A Book")
                .bookImage("img")
                .bookIsbn("123")
                .bookPages("100")
                .bookPrice(200)
                .bookRating(3.0)
                .build();

        Book book2 = Book.builder()
                .bookTitle("Moon")
                .bookAuthor("Mr Author")
                .bookCategory("Fiction")
                .bookDescription("Another Book")
                .bookImage("img")
                .bookIsbn("124")
                .bookPages("105")
                .bookPrice(250)
                .bookRating(3.5)
                .build();

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        bookService.createBookIndexBulk(books);

        System.out.println("##" + bookService.findBook("Book"));
    }

    @Test
    public void updateBookTest(){
        Book newBook = Book.builder()
                .bookTitle("Moon")
                .bookAuthor("Mr Author")
                .bookCategory("Fiction")
                .bookDescription("Another Book")
                .bookImage("img")
                .bookIsbn("194")
                .bookPages("100")
                .bookPrice(550)
                .bookRating(4.5)
                .build();

        bookService.updateBook(newBook);
    }

}
