package com.example.demo.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.example.demo.dao.BookDAO;
import com.example.demo.dao.DashboardDAO;
import com.example.demo.dao.OrderDAO;
import com.example.demo.daopackage.BookRepository;
import com.example.demo.models.Book;
import com.example.demo.models.BookOrderItem;
import com.example.demo.models.Profile;
import com.example.demo.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
        @Autowired
        private BookRepository Bookrepository;
        
        @Autowired
        private BookService Bookservice;


        @Autowired
        public DashboardDAO dashboardDAO;

        @Autowired
        public OrderDAO orderDAO;

        @Autowired
        public BookDAO bookDAO;

        private List<String> Booklist;

        
        @GetMapping(value = "/book")
        public String Bookhome( Model model ){
                model.addAttribute("Booklist", Bookrepository.findAll());
                return "book";
        }
        @PostMapping(value = "/book")
        public String addBook(@RequestParam("name") String name,@RequestParam("author") String author,@RequestParam("level") String level,@RequestParam("edition") String edition,@RequestParam("genre") String genre,@RequestParam("selling_price") long selling_price,@RequestParam("marked_price") long marked_price,@RequestParam("discounted_price") long discounted_price,@RequestParam("stock") long stock, Model model) {
                Bookservice.addABook(name, author, level,selling_price,marked_price,discounted_price,stock,edition,genre);
                System.out.println("name = " + name);
                return "redirect:/book";
        }

        private class BookItem {
                private List<Book> book;
                private List<Long> quantities;

                public BookItem(List<Book> book, List<Long> quantities) {
                        this.book = book;
                        this.quantities = quantities;
                }

                public List<Book> getBook() {
                        return book;
                }

                public void setBook(List<Book> book) {
                        this.book = book;
                }

                public List<Long> getQuantities() {
                        return quantities;
                }

                public void setQuantities(List<Long> quantities) {
                        this.quantities = quantities;
                }
        }

        @GetMapping(value = "/order-book")
        public String orderBookView( Model model, Principal principal) {
                List<Book> books = bookDAO.ListBook();
                model.addAttribute("books", books);
                Profile profile = dashboardDAO.getProfileByUserName(principal.getName());
                model.addAttribute("profile", profile);
                model.addAttribute("addresses", dashboardDAO.ListAddress(profile.getId()));
                model.addAttribute("phones", dashboardDAO.ListPhoneNumber(profile.getId()));
                return "book-order";
        }

        @PostMapping(value = "/order-book")
        public String orderBookSubmit(
                        @RequestParam("profileid") Long profileid,
                        @RequestParam("books") List<Long> books,
                        @RequestParam("address") Long address,
                        @RequestParam("phone") Long phone,
                        @RequestParam("mode") String mode,
                        Model model
        ) {
                System.out.println(books);
                orderDAO.placeOrderForBooks(books, mode, address, phone, profileid);
                return "redirect:/ordered-books";
        }

        @GetMapping(value = "/ordered-books")
        public String orderedBooks( Model model, Principal principal) {
                Profile profile = dashboardDAO.getProfileByUserName(principal.getName());
                List<BookOrderItem> items = orderDAO.findBookOrdersByProfile(profile.getId());
				HashMap<Long, List<BookOrderItem>> hashMap = new HashMap<Long, List<BookOrderItem>>();
				for(BookOrderItem item: items) {
                	if (!hashMap.containsKey(item.getOrder().getId())) {
                        List<BookOrderItem> list = new ArrayList<BookOrderItem>();
                        list.add(item);
                        hashMap.put(item.getOrder().getId(), list);
                    } else {
                        hashMap.get(item.getOrder().getId()).add(item);
                    }
				}
				model.addAttribute("orders", hashMap);
                return "ordered-books";
        }

    
        @PostMapping(value = "/delete")
        public String deleteBook(@RequestParam("name") String name,
                        @RequestParam("id") Long id) {
                Bookservice.deleteABook(name, id);
                System.out.println("Book named = " + name + "was removed from our database.");
                return "redirect:/book";
        }
         @PostMapping(value = "/update")
        public String updateBook(@RequestParam("name") String name,
                        @RequestParam("id") Long id,@RequestParam("stock") Long stock) {
                Bookservice.updateBookStock(name, id,stock);
                System.out.println("Book named = " + name + "was updated in database.");
                return "redirect:/book";
        }
    }
