package com.akatosh.sportsshop.controllers;

import com.akatosh.sportsshop.models.Category;
import com.akatosh.sportsshop.models.Manufacturer;
import com.akatosh.sportsshop.models.Product;
import com.akatosh.sportsshop.models.view_models.ProductViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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

        products.add(new Product(1, "Bow Shoes", "These are the best shoes ever.", "https://cdn.childrensalon.com/media/catalog/product/cache/0/image/1000x1000/9df78eab33525d08d6e5fb8d27136e95/c/h/children-s-classics-girls-pink-patent-shoes-with-bow-115814-5cef3fab1178cadc12c4d3b76e9ec00d9ef06641.jpg", categories.get(0), manufacturers.get(0)));
        products.add(new Product(2, "Bow-Man Shirt", "This is the best shirt ever.", "https://www.sportware.se/images/2.3463/sail-racing-bowman-shirt-stripe.jpeg", categories.get(1), manufacturers.get(0)));
        products.add(new Product(3, "Rain-Man Shirt", "This is the best rain shirt ever.", "https://a1cf74336522e87f135f-2f21ace9a6cf0052456644b80fa06d4f.ssl.cf2.rackcdn.com/images/characters/p-rain-man-dustin-hoffman.jpg", categories.get(1), manufacturers.get(0)));
    }

    @GetMapping(value = "products")
    public String getProducts(Model model) {
        model.addAttribute("products", products);

        return "products";
    }

    @GetMapping(value = "products/{id}")
    public String getProduct(@PathVariable(value = "id") long id, Model model) {
        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(products.get(0));

        model.addAttribute("product", product);

        return "product";
    }

    @GetMapping(value = "products/add")
    public String addProduct(Model model) {
        model.addAttribute("categories", categories);
        model.addAttribute("manufacturers", manufacturers);

        return "product_add";
    }

    @PostMapping(value = "products/add")
    public String addProduct(@Valid @ModelAttribute("productViewModel") ProductViewModel viewModel) {
        Category category = categories.stream()
                .filter(c -> c.getId() == viewModel.getCategory())
                .findFirst()
                .orElse(categories.get(0));

        Manufacturer manufacturer = manufacturers.stream()
                .filter(m -> m.getId() == viewModel.getManufacturer())
                .findFirst()
                .orElse(manufacturers.get(0));

        Product product = new Product(viewModel.getId(), viewModel.getName(), viewModel.getDescription(),
                viewModel.getLink(), category, manufacturer);

        products.add(product);

        return "redirect:/products";
    }
}
