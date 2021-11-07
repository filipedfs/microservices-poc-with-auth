package com.filipefonseca.orderservice.controller;

import com.filipefonseca.orderservice.client.InventoryClient;
import com.filipefonseca.orderservice.dto.OrderDto;
import com.filipefonseca.orderservice.model.Order;
import com.filipefonseca.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/order")
@Slf4j
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    private final StreamBridge streamBridge;
    private final ExecutorService traceableExecutorService;

    //    @GetMapping
    //    public String index() {
    //        return "Orders!";
    //    }

    @GetMapping
    public String indexO() {
        return inventoryClient.checkStock("IPHONE_12_RED").toString();
    }

    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {
        circuitBreakerFactory.configureExecutorService(traceableExecutorService);
        Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("inventory");
        Supplier<Boolean> booleanSupplier = () -> orderDto.getOrderLineItems().stream()
                .allMatch(orderLineItem -> {
                    log.info("Making call to Inventory Service for SkuCode {}.", orderLineItem.getSkuCode());
                    return inventoryClient.checkStock(orderLineItem.getSkuCode());
                });

        boolean allProductsInStock = circuitBreaker.run(booleanSupplier, this::handleErrorCase);

        if (allProductsInStock) {
            Order order = new Order();
            order.setOrderLineItems(order.getOrderLineItems());
            order.setOrderNumber(UUID.randomUUID().toString());
            orderRepository.save(order);
            log.info("Sending order details with order id {} to Notification Service.", order.getId());
            streamBridge.send("notificationEventSupplier-out-0", MessageBuilder.withPayload( order.getId()));
            return "Order placed successfully";
        }
        else {
            return "Not all products are in stock";
        }
    }

    private Boolean handleErrorCase(Throwable throwable) {
        log.error("Error occurred while checking stock", throwable);
        return false;
    }
}
