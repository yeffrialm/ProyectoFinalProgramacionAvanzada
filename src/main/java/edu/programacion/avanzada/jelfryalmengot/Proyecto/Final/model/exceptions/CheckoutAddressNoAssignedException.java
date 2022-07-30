package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions;

import java.text.MessageFormat;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
public class CheckoutAddressNoAssignedException extends RuntimeException {

    public CheckoutAddressNoAssignedException(UUID id) {
        super(MessageFormat.format("No Address in checkout {0} ", id));
    }
}
