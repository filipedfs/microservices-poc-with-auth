package com.filipefonseca.inventoryservice.repository;

import com.filipefonseca.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    /**
     * Finds an inventory by its sku code.
     */
    Optional<Inventory> findBySkuCode(String skuCode);
}
