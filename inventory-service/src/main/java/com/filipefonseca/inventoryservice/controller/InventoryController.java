package com.filipefonseca.inventoryservice.controller;

import com.filipefonseca.inventoryservice.model.Inventory;
import com.filipefonseca.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

    private final InventoryRepository inventoryRepository;

    @GetMapping("{skuCode}")
    Boolean isInStock(@PathVariable String skuCode) {
        log.info("Checking if product with skuCode {} is in stock", skuCode);
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode).orElseThrow(
                () -> new RuntimeException("Cannot find product by sku code " + skuCode));
        return inventory.getStock() > 0;
    }
}
