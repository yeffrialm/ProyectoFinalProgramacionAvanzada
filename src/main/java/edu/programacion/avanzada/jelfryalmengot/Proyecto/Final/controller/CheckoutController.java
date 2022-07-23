package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.controller;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout.CheckoutAddProductRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutAddProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutUpdateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutUpdatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.GetCheckoutResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/checkouts")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<GetCheckoutResponse> get() {
        return ResponseEntity.ok(checkoutService.getAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCheckoutResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(checkoutService.get(id));
    }

    @PostMapping("/update/address")
    public ResponseEntity<CheckoutUpdateAddressResponse> updateAddress(@RequestBody CheckoutUpdateAddressRequest checkoutUpdateAddressRequest) {
        return ResponseEntity.ok(checkoutService.updateAddress(checkoutUpdateAddressRequest));
    }

    @PostMapping("/update/payment/method")
    public ResponseEntity<CheckoutUpdatePaymentMethodResponse> updatePaymentMethod(@RequestBody CheckoutUpdatePaymentMethodRequest checkoutUpdatePaymentMethodRequest) {
        return ResponseEntity.ok(checkoutService.updatePaymentMethod(checkoutUpdatePaymentMethodRequest));
    }

    @PostMapping("/add/product")
    public ResponseEntity<CheckoutAddProductResponse> addProduct(@RequestBody CheckoutAddProductRequest checkoutAddProductRequest) {
        return ResponseEntity.ok(checkoutService.addProducts(checkoutAddProductRequest));
    }
}
