package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions;

import java.text.MessageFormat;


public class AddressNoFoundException extends RuntimeException {

    public AddressNoFoundException(Long id) {
        super(MessageFormat.format("Address {0} no found", id));
    }
}
