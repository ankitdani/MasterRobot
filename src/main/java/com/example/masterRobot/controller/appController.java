package com.example.masterRobot.controller;

import com.example.masterRobot.entity.ComicBooks;
import com.example.masterRobot.entity.CustOrder;
import com.example.masterRobot.entity.store_items;
import com.example.masterRobot.entity.CartoonMovies;
import com.example.masterRobot.repository.storeItemRepository;
import com.example.masterRobot.service.CartoonMoviesService;
import com.example.masterRobot.service.ComicBooksService;
import com.example.masterRobot.service.CustOrderService;
import com.example.masterRobot.service.storeItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class appController {
    @Autowired
    storeItemRepository repo;
    @Autowired
    storeItemsService service;
    @Autowired
    ComicBooksService comicBooksService;
    @Autowired
    CartoonMoviesService cartoonMoviesService;
//    @GetMapping("/")
//    public String display(){
//        store_items store_item = new store_items(11, 1000, 2);
//
//        repo.save(store_item);
//        System.out.println(repo.findAll());
//        System.out.println();
//        return repo.findAll().stream().findFirst().toString();
//    }

    class ItemDetails{
        public store_items storeItem;
        public ComicBooks comicBook;
        public CartoonMovies cartoonMovie;

        public ItemDetails(store_items storeItem, CartoonMovies cartoonMovie) {
            this.storeItem = storeItem;
            this.cartoonMovie = cartoonMovie;
        }
        public ItemDetails(store_items storeItem, ComicBooks comicBook) {
            this.storeItem = storeItem;
            this.comicBook = comicBook;
        }
    }
    @RequestMapping("/")
    public ModelAndView viewHomePage() {
        List<store_items> listItems = service.list();
        List<ComicBooks> listBooks = comicBooksService.listBooks();
        List<CartoonMovies> listMovies = cartoonMoviesService.listMovies();
        int i=0,j=0,k=0;
        List<ItemDetails> itemDetailsList = new ArrayList<ItemDetails>();
        for(; i<listItems.size() && j<listBooks.size() && k<listMovies.size(); i++){
            if(listItems.get(i).getItem_id()==listBooks.get(j).getItem_id()){
                itemDetailsList.add(new ItemDetails(listItems.get(i), listBooks.get(j)));
                j++;
                continue;
            }
            if(listItems.get(i).getItem_id()==listMovies.get(k).getItemId()){
                itemDetailsList.add(new ItemDetails(listItems.get(i), listMovies.get(k)));
                k++;
            }
        }
        if(j==listBooks.size()){
            for(;i<listItems.size() && k< listMovies.size();  i++){
                if(listItems.get(i).getItem_id()==listMovies.get(k).getItemId()){
                    itemDetailsList.add(new ItemDetails(listItems.get(i), listMovies.get(k)));
                    k++;
                }
            }
        }
        if(k==listMovies.size()){
            for(;i<listItems.size() && j< listBooks.size();  i++){
                if(listItems.get(i).getItem_id()==listBooks.get(j).getItem_id()){
                    itemDetailsList.add(new ItemDetails(listItems.get(i), listBooks.get(j)));
                    j++;
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("itemDetailsList", itemDetailsList);
        return modelAndView;
    }
//    @RequestMapping("/")
//    public ModelAndView viewHomePage(Model model) {
//        CustOrder custOrder = new CustOrder();
//        List<ComicBooks> listBooks = comicBooksService.listBooks();
//        System.out.println(listBooks);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        modelAndView.addObject("listBooks",listBooks);
//        return modelAndView;
//    }

}
