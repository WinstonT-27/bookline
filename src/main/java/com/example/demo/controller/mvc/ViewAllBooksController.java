package com.example.demo.controller.mvc;

import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewAllBooksController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/admin/books")
    public String viewBooks(Model model){
        model.addAttribute("books", bookService.getAllBooks());
        return "viewAllBooks";
    }

//    @Autowired
//    private PaginationService paginationService;

//    @GetMapping(value = { "/admin/books"})
//    public String viewAllBooks(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size, Model model){
//        int currentPage = page.orElse(1);
//        int pageSize = size.orElse(20);
//
//        Page<Book> bookPage = paginationService.findBookPagination(PageRequest.of(currentPage - 1,  pageSize));
//
//        model.addAttribute("books", bookPage);
//
//        int totalPages = bookPage.getTotalPages();
//        if(totalPages > 0){
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumebers", pageNumbers);
//        }
//
//        return "viewAllBooks";
//    }
}
