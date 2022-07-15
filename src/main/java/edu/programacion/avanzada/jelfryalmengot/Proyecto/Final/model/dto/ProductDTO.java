package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProductDTO {

    private Long id;

    private String name;

    private String description;

    private long availableQuantity;

    private BigDecimal price;

}
