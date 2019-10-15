package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.daopackage.StationaryRepository;
import com.example.demo.models.Stationary;
import com.example.demo.services.StationaryService;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StationaryController {
        @Autowired
        private StationaryRepository Stationaryrepository;
        @Autowired
        private StationaryService Stationaryservice;
        private List<String> Stationarylist = null;
        @GetMapping(value = "/stationary")
        public String Stationaryhome( Model model ){
                        model.addAttribute("Stationarylist", Stationaryrepository.findAll());
                        return "stationary";
                }
        @PostMapping(value = "/stationary")
        public String addStationary(@RequestParam("item_type") String item_type,@RequestParam("brand") String brand,@RequestParam("selling_price") long selling_price,@RequestParam("marked_price") long marked_price,@RequestParam("discounted_price") long discounted_price,@RequestParam("stock") long stock, Model model) {
                Stationaryservice.addAStationary(item_type,stock,brand,selling_price,marked_price,discounted_price);
                return "redirect:/stationary";
        }
    
        @PostMapping(value = "/delete-stationary")
        public String deleteStationary(@RequestParam("item_type") String item_type,
                        @RequestParam("id") Long id) {
                Stationaryservice.deleteAStationary(item_type, id);
                return "redirect:/stationary";
        }
         @PostMapping(value = "/update-stationary")
        public String updateStationary(@RequestParam("item_type") String item_type,
                        @RequestParam("id") Long id,@RequestParam("stock") Long stock) {
                Stationaryservice.updateStationaryStock(item_type, id,stock);
                return "redirect:/stationary";
        }
    }