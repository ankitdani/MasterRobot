package com.example.masterRobot.controller;

import com.example.masterRobot.entity.*;
import com.example.masterRobot.repository.storeItemRepository;
import com.example.masterRobot.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameterValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"currentCustomer"})
public class appController {
    @Autowired
    storeItemRepository repo;
    @Autowired
    storeItemsService service;
    @Autowired
    ComicBooksService comicBooksService;
    @Autowired
    CartoonMoviesService cartoonMoviesService;
    @Autowired
    CartItemService  cartItemService;
    @Autowired
    JdbcTemplate template;
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
            this.comicBook = new ComicBooks();
        }
        public ItemDetails(store_items storeItem, ComicBooks comicBook) {
            this.storeItem = storeItem;
            this.comicBook = comicBook;
            this.cartoonMovie = new CartoonMovies();
        }
    }
    @RequestMapping("/")
    public ModelAndView viewLoginPage(){
        ModelAndView mav = new ModelAndView();
        CurrentCustomer currentCustomer=new CurrentCustomer();
//        mav.addObject("currentCustomer",new Long());
        mav.setViewName("login");
        return mav;
    }
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("currentCustomer") CurrentCustomer currentCustomer){
        System.out.println("cust id"+currentCustomer.getCust_id());
        return "redirect:home";
    }
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView viewHomePage() {
        CartItem cartItem = new CartItem();
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
        modelAndView.addObject("cartItem", cartItem);
        modelAndView.addObject("itemDetailsList", itemDetailsList);
        System.out.println("itemdetailslist - "+itemDetailsList.get(0));
        return modelAndView;
    }
    @RequestMapping("/addToCart/{item_id}")
    public String checkout(@ModelAttribute("cartItem") CartItem cartItem, @PathVariable long item_id) {
        System.out.println(cartItem.getItem_id());
        cartItem.setItem_id(item_id);
        cartItem.setCust_id(1000);
        store_items s = service.get(item_id);
        cartItem.setPrice(s.getPrice());
        long price = s.getPrice();
        cartItem.setTax(0.05*(price* cartItem.getQuantity()));
        cartItem.setTotal((price* cartItem.getQuantity())+ cartItem.getTax());
        cartItemService.saveCartItem(cartItem);
        return "redirect:/home";

    }
    @RequestMapping("/cart/{cust_id}")
    public ModelAndView displayCart(@PathVariable long cust_id) {
        System.out.println(cust_id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cart");
        List<CartItem> cartItemList = cartItemService.listByCustId(cust_id);
        modelAndView.addObject("cartItemsList",cartItemList);
        return modelAndView;
    }

    @RequestMapping("/checkout/{cust_id}")
    public String checkout(@PathVariable long cust_id){
        //add to cust order and orderlineitems
        //add to payment details
        List<CartItem> cartItemsList = cartItemService.listByCustId(cust_id);
        //create custorder

        //create orderlineitems
        //set shipping date
        //compute total



        return "orderPlaced";
    }

        //RequestMappingappi
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
