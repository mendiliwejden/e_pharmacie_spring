package com.project.e_pharmacie_spring.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.project.e_pharmacie_spring.models.Category;
import com.project.e_pharmacie_spring.models.Product;
import com.project.e_pharmacie_spring.services.CategoryService;
import com.project.e_pharmacie_spring.services.ProductService;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "products/save", method = RequestMethod.POST)
    public String saveProduct(@RequestParam("image") final MultipartFile imageFile,
            @RequestParam("name") final String name, @RequestParam("quantity") final int quantity,
            @RequestParam("price") final double price, @RequestParam("description") final String description,
            @RequestParam("category") int category_id) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setCategory(categoryService.getCategoryById(category_id));
        product.setDescription(description);

        product.setImage(Base64.getEncoder().encodeToString(imageFile.getBytes()));
        System.out.print(product.getImage());
        service.saveProduct(product);
        return "redirect:/products";

    }

    @GetMapping("/products")
    public String getProducts(final Model model) {

        ///////// list product/////////
        List<Product> productList = new ArrayList<Product>();
        productList = service.listAllProducts();
        model.addAttribute("product_list", productList);
        /////////// add product//////
        addProduct(model);

        return "products";
    }

    public void addProduct(final Model model) {
        final Product product = new Product();
        List<Category> categoryList = new ArrayList<Category>();
        categoryList = categoryService.listAllCategories();
        model.addAttribute("category_list", categoryList);
        model.addAttribute("product", product);
    }


    @GetMapping("/products/edit/{id}")
    public String showUpdatedForm(@PathVariable("id") final int id, final Model model) {

        final Product existing_product = service.getProductById(id);
        model.addAttribute("product", existing_product);

        model.addAttribute("category_list", categoryService.listAllCategories());

        return "edit_product";
    }

    @PostMapping("products/update/{id}")
    public String updateProduct(@PathVariable("id") final int id, final Product product, final BindingResult result,
            final Model model) {
        if (result.hasErrors()) {
            return "404";
        }
        Product existing_product = service.getProductById(id);

        product.setImage(existing_product.getImage());
        service.saveProduct(product);
        model.addAttribute("product_list", service.listAllProducts());
        return "redirect:/products";
    }

    @GetMapping("products/delete/{id}")
    public String deleteProduct(@PathVariable("id") final int id, final Model model) {

        service.deleteProduct(id);
        model.addAttribute("product_list", service.listAllProducts());
        return "redirect:/products";
    }
}