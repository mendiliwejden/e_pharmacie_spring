package com.project.e_pharmacie_spring.controllers;

import java.util.ArrayList;
import java.util.List;

import com.project.e_pharmacie_spring.models.Category;
import com.project.e_pharmacie_spring.services.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/categories")
    public String getCategories(Model model) {
        List<Category> categoryList = new ArrayList<Category>();
        categoryList = service.listAllCategories();
        model.addAttribute("category_list", categoryList);
        return "categories";
    }

    @RequestMapping(value = "categories/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category category) {
        service.save(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit/{id}")
    public String showUpdatedForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("category", service.getCategoryById(id));

        return "edit_category";
    }

    @PostMapping("categories/update/{id}")
    public String updateCategory(@PathVariable("id") int id, Model model, Category category, BindingResult result) {
        if (result.hasErrors())
            return "404";
        service.save(category);
        model.addAttribute("category_list", service.listAllCategories());

        return "redirect:/categories";
    }

    @GetMapping("categories/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id, Model model) {

        service.delete(id);
        model.addAttribute("category_list", service.listAllCategories());
        return "redirect:/categories";
    }
}