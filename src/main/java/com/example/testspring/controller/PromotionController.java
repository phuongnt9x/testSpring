package com.example.testspring.controller;

import com.example.testspring.Service.IPromotionService;
import com.example.testspring.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/promotions")
public class PromotionController {
    @Autowired
    private IPromotionService promotionService;
    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("promotion", new Promotion());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("promotion") Promotion promotion) {
        promotionService.save(promotion);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("promotion", new Promotion());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }
    @GetMapping()
    public ModelAndView listPromotion() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("promotions", promotionService.findAll());
        return modelAndView;
    }

}
