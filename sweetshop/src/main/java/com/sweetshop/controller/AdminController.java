package com.sweetshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sweetshop.model.Sweet;
import com.sweetshop.service.SweetService;

@Controller
@RequestMapping("/admin/sweets")
public class AdminController {

    private final SweetService service;

    public AdminController(SweetService service) {
        this.service = service;
    }

    // List all sweets
    @GetMapping
    public String list(Model model) {
        model.addAttribute("sweets", service.list());
        model.addAttribute("sweet", new Sweet());
        return "admin-sweets";
    }

    // Add new sweet
    @PostMapping("/add")
    public String add(@ModelAttribute Sweet sweet) {
        service.add(sweet);
        return "redirect:/admin/sweets";
    }

    // Delete sweet
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admin/sweets";
    }

    // Edit sweet page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("sweet", service.getById(id));
        return "edit-sweet";
    }

    // Update sweet
    @PostMapping("/update")
    public String update(@ModelAttribute Sweet sweet) {
        service.update(sweet.getId(), sweet);
        return "redirect:/admin/sweets";
    }
}
