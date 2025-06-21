package com.hafssa.gestion_commandes.web;

import com.hafssa.gestion_commandes.model.Product;
import com.hafssa.gestion_commandes.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ProductRepository produitRepository;

    @GetMapping("/homeUser")
    public String homeUser() {
        return "homeUser";
    }

    @GetMapping("/homeAdmin")
    public String homeAdmin() {
        return "homeAdmin";
    }

    @GetMapping("/user/products")
    public String userProducts(Model model) {
        List<Product> produits = produitRepository.findAll();
        model.addAttribute("products", produits);
        return "userProducts";  // Crée cette page HTML dans /templates
    }
}
