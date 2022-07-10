package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.network.dto;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.ProductState;

import lombok.*;

import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductDTO {

    private Long id;

    private String nombre_producto;

    private Integer cantidad;

    private Boolean disponible;

    private BigDecimal precio;

    /**
     * Ejemplo de un enum con @JsonValue
     */
    private ProductState state;
}
