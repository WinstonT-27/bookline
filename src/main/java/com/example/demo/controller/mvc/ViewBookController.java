package com.example.demo.controller.mvc;

import com.example.demo.controller.utils.Session;
import com.example.demo.models.Book;
import com.example.demo.models.Cart;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ViewBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/books/{title}")
    public String viewBook(@ModelAttribute("title") String bookTitle, Model model){
        Book book = bookService.findBook(bookTitle).get(0);
        model.addAttribute("book", book);
        model.addAttribute("cart", new Cart());
        return "viewBook";
    }

    @GetMapping(value = "/books/cart/add/{title}")
    public String insertBookToCart(@ModelAttribute("title") String title, Model model){
        try{
            int oldQuantity = userService.checkIfBookExistInCart(Session.getSession(), title);
            if(oldQuantity > 0){
                userService.changeCartItemQuantity(Session.getSession(), title, oldQuantity + 1);
            }
            else userService.addBookToCart(Session.getSession(), title);
            model.addAttribute("book", bookService.findBook(title));
            return "viewBook";
        }
        catch (NullPointerException e){
            return "redirect:/login";
        }
    }

    @GetMapping(value = "/wishlist/add/{title}")
    public String insertBookToWishlist(@ModelAttribute("title") String title){
        try{
            if(!userService.checkBookExistInWishlist(Session.getSession(), title)){
                userService.addBookToWishlist(Session.getSession(), title);
                return "redirect:/books/" + title;
            }
            return "viewBook";
        }
        catch (NullPointerException e){
            return "redirect:/login";
        }
    }
}
