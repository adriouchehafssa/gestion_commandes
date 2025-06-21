package com.hafssa.gestion_commandes.web;

import com.hafssa.gestion_commandes.model.Order;
import com.hafssa.gestion_commandes.model.Panier;
import com.hafssa.gestion_commandes.repository.OrderRepository;
import com.hafssa.gestion_commandes.repository.PanierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private PanierRepository panierRepository;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/validate")
    public String validerCommande(Model model) {
        List<Panier> panierItems = panierRepository.findAll();

        if (panierItems.isEmpty()) {
            model.addAttribute("message", "Votre panier est vide !");
            return "redirect:/cart/view";
        }

        for (Panier item : panierItems) {
            Order order = new Order();
            order.setProduit(item.getProduit());
            order.setQuantity(item.getQuantity());
            orderRepository.save(order);
        }

        panierRepository.deleteAll();
        model.addAttribute("message", "Commande validée avec succès !");
        return "redirect:/user/orders";
    }

    @GetMapping("/user/orders")
    public String afficherCommandes(Model model) {
        List<Order> commandes = orderRepository.findAll();
        model.addAttribute("orders", commandes);
        return "orders"; // nom du fichier orders.html
    }
}
