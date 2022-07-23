package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.checkout;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.CreateAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.CheckoutAddProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Checkout;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.CheckoutProduct;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Product;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutAddProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.CheckoutRepository;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CreateAddressCommand.class)
@Slf4j

public class CheckoutAddProductCommandHandler implements CommandHandler<CheckoutAddProductResponse, CheckoutAddProductCommand> {

    private final CheckoutRepository checkoutRepository;
    private final ProductRepository productRepository;

    @Override
    public CheckoutAddProductResponse handle(CheckoutAddProductCommand checkoutAddProductCommand) {
        Checkout checkout = checkoutRepository.findById(checkoutAddProductCommand.getId()).orElseThrow();
        Product product = productRepository.findById(checkoutAddProductCommand.getProductsToBuy()).orElseThrow();
        if (checkoutAddProductRequest.getQuantity() > product.getAvailableQuantity()) {
            throw new RuntimeException("Available product if less than you need");
        }
        List<CheckoutProduct> productsToBuy = checkout.getProductsToBuy();
        if (productsToBuy == null) {
            productsToBuy = new ArrayList<>();
        }
        CheckoutProduct checkoutProduct = findProductInCheckout(productsToBuy, product.getId());
        if (checkoutProduct == null) {
            checkoutProduct = CheckoutProduct.builder()
                    .product(product)
                    .quantity(checkoutAddProductRequest.getQuantity())
                    .build();
            checkoutProductRepository.save(checkoutProduct);
            productsToBuy.add(checkoutProduct);
        } else {
            checkoutProduct.setQuantity(checkoutProduct.getQuantity() + checkoutAddProductRequest.getQuantity());
            checkoutProductRepository.save(checkoutProduct);
        }
        product.setAvailableQuantity(product.getAvailableQuantity() - checkoutAddProductRequest.getQuantity());
        productRepository.save(product);
        checkout.setProductsToBuy(productsToBuy);
        checkoutRepository.save(checkout);
        return checkout.toDTO();
}