package com.akatosh.sportsshop.controllers;

import com.akatosh.sportsshop.models.Category;
import com.akatosh.sportsshop.models.Manufacturer;
import com.akatosh.sportsshop.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/")
public class ProductsController {
    private List<Product> products;
    private List<Category> categories;
    private List<Manufacturer> manufacturers;

    ProductsController() {
        products = new ArrayList<>();
        categories = new ArrayList<>();
        manufacturers = new ArrayList<>();

        categories.add(new Category(1, "Shoes"));
        categories.add(new Category(2, "Shirts"));

        manufacturers.add(new Manufacturer(1, "Nike"));

        products.add(new Product(1, "Rainbow-Man Shoes", "These are the best shoes ever.", "", categories.get(0), manufacturers.get(0)));
        products.add(new Product(1, "Rainbow-Man Shirt", "This is the best shirt ever.", "", categories.get(1), manufacturers.get(0)));
        products.add(new Product(1, "Rain-Man Shirt", "This is the best rain shirt ever.", "", categories.get(1), manufacturers.get(0)));
    }

    @GetMapping(value = "products")
    public String getProducts(Model model) {
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping(value = "products/{id}")
    public String getProduct(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("product", products.stream().filter(p -> p.getId() == id).findFirst());

        return "product";
    }

    @GetMapping(value = "products/add")
    public String addProduct() {
        return "product_add";
    }
}
