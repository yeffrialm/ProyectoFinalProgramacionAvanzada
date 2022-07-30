package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
public class PayCheckoutWithoutProductsException extends RuntimeException {

    public PayCheckoutWithoutProductsException(UUID id) {
        super(MessageFormat.format("Checkout {0} doesnt have any product to buy", id));
    }
}
