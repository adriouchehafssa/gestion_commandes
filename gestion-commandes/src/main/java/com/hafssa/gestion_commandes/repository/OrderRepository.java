package com.hafssa.gestion_commandes.repository;

import com.hafssa.gestion_commandes.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
