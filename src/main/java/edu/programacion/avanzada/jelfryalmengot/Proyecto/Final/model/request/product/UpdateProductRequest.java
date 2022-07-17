package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product.UpdateProductCommand;
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

public class UpdateProductRequest {

    private Long id;
    private String description;
    private long availableQuantity;
    private BigDecimal price;


    public UpdateProductCommand toCommand() {
        return UpdateProductCommand.builder()
                .id(id)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }


}
