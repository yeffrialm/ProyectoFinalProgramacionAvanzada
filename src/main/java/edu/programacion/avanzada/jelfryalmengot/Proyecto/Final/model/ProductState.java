package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;

/**
 * El uso de property es para hacerlo directo, pero si queremos un tipo de dato especifico como entero
 * usamos el @JsonValue, solo que debemos también definir la lectura
 *
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
public enum ProductState {
    NOMBRE_PRODUCTO(0),
    CANTIDAD(1),
    DISPONIBLE(2),
    PRECIO(3);
    private final int code;

    @JsonValue
    public int getCode() {
        return code;
    }


}
