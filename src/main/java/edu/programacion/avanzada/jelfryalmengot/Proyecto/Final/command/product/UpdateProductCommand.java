package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.UpdateProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.Command;
import lombok.*;

import java.math.BigDecimal;

/**
 * @author jelfry on 7/09/2022.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class UpdateProductCommand extends Command<UpdateProductResponse> {

    private Long id;
    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

}