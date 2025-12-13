package com.sweetshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sweetshop.service.SweetService;
@Controller
public class SweetMvcController {

    private final SweetService service;

    public SweetMvcController(SweetService service) {
        this.service = service;
    }

    @GetMapping("/sweets")
    public String list(Model model) {
        model.addAttribute("sweets", service.list());
        return "sweets";   // loads sweets.jsp
    }

    @PostMapping("/{id}/purchase")
    public String purchase(@PathVariable Long id) {
        service.purchase(id);
        return "redirect:/sweets";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
