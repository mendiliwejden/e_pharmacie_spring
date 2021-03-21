package com.project.e_pharmacie_spring.controllers;

import java.time.LocalDate;
import java.util.Date;

import javax.xml.ws.Service;

import com.project.e_pharmacie_spring.models.Command;
import com.project.e_pharmacie_spring.services.CommandService;
import com.project.e_pharmacie_spring.services.ProductService;
import com.project.e_pharmacie_spring.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommandController {

    @Autowired
    CommandService service;
    @Autowired
    UserService service_user;
    @Autowired
    ProductService service_product;

    @GetMapping("/commands")
    public String getCommands(Model model) {

        model.addAttribute("command_list", service.listAllCommands());
        return "commands";
    }

    @GetMapping("commands/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id, Model model) {

        service.deleteCommand(id);
        model.addAttribute("category_list", service.listAllCommands());
        return "redirect:/categories";
    }

}