package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.controller;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.order.GetOrderResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<GetOrderResponse> get() {
        return ResponseEntity.ok(GetOrderResponse.builder()
                .orders(orderService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetOrderResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(GetOrderResponse.builder()
                .orders(List.of(orderService.get(id)))
                .build());
    }
}
