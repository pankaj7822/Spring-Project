package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.daopackage.ProfileRepository;
import com.example.demo.models.Profile;
import com.example.demo.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {
        @Autowired
        private ProfileRepository Profilerepository;
        @Autowired
        private ProfileService Profileservice;
        private List<String> Profilelist = null;
        @GetMapping(value = "/all-profile")
        public String Profilehome( Model model ){
                        model.addAttribute("Profilelist", Profilerepository.findAll());
                        return "profile";
                }
        @PostMapping(value = "/all-profile")
        public String addProfile(@RequestParam("name") String name,@RequestParam("points") Long points,@RequestParam("User_id") Long User_id, Model model) {
                Profileservice.addAProfile(name,points,User_id);
                return "redirect:/all-profile";
        }

        // @GetMapping(value = "/user-profile")
        // public String Profilehome( Model model ){
        //                 model.addAttribute("Profilelist", Profilerepository.findAll());
        //                 return "profile";
        //         }

        // @PostMapping(value = "/user-profile")
        // public String addProfile(@RequestParam("name") String name,@RequestParam("points") Long points,@RequestParam("User_id") Long User_id, Model model) {
        //         Profileservice.addAProfile(name,points,User_id);
        //         return "redirect:/all-profile";
        // }

        @PostMapping(value = "/delete-profile")
        public String deleteProfile(@RequestParam("name") String name,
                        @RequestParam("id") Long id) {
                Profileservice.deleteAProfile(name, id);
                System.out.println("Profile named = " + name + "was removed from our database.");
                return "redirect:/all-profile";
        }
         @PostMapping(value = "/update-profile")
        public String updateProfile(@RequestParam("name") String name,
                        @RequestParam("id") Long id,@RequestParam("points") Long points) {
                Profileservice.updateProfilePoint(name, id,points);
                return "redirect:/all-profile";
        }
    }
