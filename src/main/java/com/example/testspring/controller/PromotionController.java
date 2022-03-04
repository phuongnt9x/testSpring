package com.example.testspring.controller;

import com.example.testspring.Service.IPromotionService;
import com.example.testspring.model.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

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
    public ModelAndView saveCustomer(@Valid @ModelAttribute("promotion") Promotion promotion) {
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
    @GetMapping("/update/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Promotion> promotionOptional = promotionService.findById(id);
        if (promotionOptional.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("customer", promotionOptional.get());
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping("/update")
    public ModelAndView updateCustomer(@ModelAttribute("promotion") Promotion promotion) {
        promotionService.save(promotion);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("promotion", promotion);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

}
