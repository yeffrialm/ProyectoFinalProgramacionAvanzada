package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product.CreateProductCommand;
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

public class CreateProductRequest {


    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;


    public CreateProductCommand toCommand() {
        return CreateProductCommand.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }
}
