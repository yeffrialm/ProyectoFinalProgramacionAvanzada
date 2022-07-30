package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
public class CheckoutNoFoundException extends RuntimeException {

    public CheckoutNoFoundException(UUID id) {
        super(MessageFormat.format("Checkout {0} no found", id));
    }
}
