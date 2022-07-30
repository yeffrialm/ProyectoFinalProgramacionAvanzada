package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
public class CheckoutPaymentMethodNoAssignedException extends RuntimeException {

    public CheckoutPaymentMethodNoAssignedException(UUID id) {
        super(MessageFormat.format("No payment method in checkout {0} ", id));
    }
}
