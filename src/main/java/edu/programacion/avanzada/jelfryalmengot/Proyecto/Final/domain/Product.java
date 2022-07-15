package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.ProductDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product.UpdateProductRequest;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private long availableQuantity;

    @Column
    private BigDecimal price;


    /**
     * Patrón más integrado y adecuado en la lógica, cada objeto se hace responsable de sus conversiones
     *
     * @return Modelo DTO del Product
     */
    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .id(id)
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }

    public void applyChanges(UpdateProductRequest updateProductRequest) {
        description = updateProductRequest.getDescription();
        availableQuantity = updateProductRequest.getAvailableQuantity();
        price = updateProductRequest.getPrice();
    }
}
