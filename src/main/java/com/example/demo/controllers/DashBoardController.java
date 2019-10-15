package com.example.demo.controllers;

import java.security.Principal;
import java.util.List;

import com.example.demo.dao.DashboardDAO;
import com.example.demo.models.Profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DashBoardController {

    @Autowired
    public DashboardDAO dashboardDAO;


    @GetMapping(value = "/DashBoard")
    public String DashBoardhome(Model model, Principal principal) {
        System.out.println(principal.getName());
        Profile profile = dashboardDAO.getProfileByUserName(principal.getName());
        model.addAttribute("profile", profile);
        model.addAttribute("addresses", dashboardDAO.ListAddress(profile.getId()));
        model.addAttribute("phones", dashboardDAO.ListPhoneNumber(profile.getId()));
        return "userdashboard";
    }
        @PostMapping(value = "/update-your-profile")
        public String updateProfile(@RequestParam("name") String name, Model model, Principal principal) {
            Profile profile = dashboardDAO.getProfileByUserName(principal.getName());
                dashboardDAO.updateProfile(name,profile.id);
                return "redirect:/DashBoard";
        }
    
        @PostMapping(value = "/add-address")
        public String addAddress(@RequestParam("state") String state,@RequestParam("district") String district,@RequestParam("city") String city,@RequestParam("pincode") String pincode, @RequestParam("landmark") String landmark, Model model, Principal principal) {
            Profile profile = dashboardDAO.getProfileByUserName(principal.getName());
                dashboardDAO.addAddress(state,district,city,pincode,landmark,profile.getId());
                return "redirect:/DashBoard";
        }
         @PostMapping(value = "/update-address")
        public String updateDashBoard(@RequestParam("state") String state,@RequestParam("district") String district,@RequestParam("city") String city,@RequestParam("pincode") String pincode, @RequestParam("landmark") String landmark, @RequestParam("id") Long id, Model model) {
                dashboardDAO.updateAddress(state, district, city, pincode, landmark, id);
                return "redirect:/DashBoard";
        }
        @PostMapping(value = "/add-phonenumber")
        public String addAddress(@RequestParam("phone_number") String phone_number, Principal principal) {
            Profile profile = dashboardDAO.getProfileByUserName(principal.getName());
                dashboardDAO.addPhoneNumber(phone_number, profile.getId());
                return "redirect:/DashBoard";
        }
         @PostMapping(value = "/update-phonenumber")
        public String updateDashBoard(@RequestParam("phone_number") String phone_number,@RequestParam("id") Long id) {
                dashboardDAO.updatePhoneNumber(phone_number, id);
                return "redirect:/DashBoard";
        }
    }
