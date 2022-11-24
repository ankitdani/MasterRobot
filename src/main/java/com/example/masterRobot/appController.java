package com.example.masterRobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class appController {
    @Autowired
    storeItemRepository repo;
    @Autowired
    storeItemsService service;
//    @GetMapping("/")
//    public String display(){
//        store_items store_item = new store_items(11, 1000, 2);
//
//        repo.save(store_item);
//        System.out.println(repo.findAll());
//        System.out.println();
//        return repo.findAll().stream().findFirst().toString();
//    }

    @RequestMapping("/")
    public ModelAndView viewHomePage(Model model) {
        List<store_items> listItems = service.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("listItems", listItems);
        return modelAndView;
    }

}
