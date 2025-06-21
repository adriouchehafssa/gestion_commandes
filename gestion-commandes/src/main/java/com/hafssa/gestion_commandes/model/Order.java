package com.hafssa.gestion_commandes.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // relation ManyToOne avec produit
    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Product produit;

    private int quantity;

    private LocalDateTime dateCommande = LocalDateTime.now();
    
    @Column(name = "adresse_livraison", nullable = false, length = 255)
    private String adresseLivraison;

    @Column(name = "mode_livraison", nullable = false, length = 50)
    private String modeLivraison;

    @Column(name = "moyen_paiement", nullable = false, length = 50)
    private String moyenPaiement;

    // Getters et Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Product getProduit() { return produit; }

    public void setProduit(Product produit) { this.produit = produit; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public LocalDateTime getDateCommande() { return dateCommande; }

    public void setDateCommande(LocalDateTime dateCommande) { this.dateCommande = dateCommande; }
    public String getAdresseLivraison() { return adresseLivraison; }

    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }

    public String getModeLivraison() { return modeLivraison; }

    public void setModeLivraison(String modeLivraison) { this.modeLivraison = modeLivraison; }

    public String getMoyenPaiement() { return moyenPaiement; }

    public void setMoyenPaiement(String moyenPaiement) { this.moyenPaiement = moyenPaiement; }
}
