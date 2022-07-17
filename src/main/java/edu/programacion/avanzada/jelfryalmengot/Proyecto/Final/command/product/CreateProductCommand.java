package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Product;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.CreateProductResponse;
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

public class CreateProductCommand extends Command<CreateProductResponse> {

    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;


    public Product toProduct() {
        return Product.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }


}