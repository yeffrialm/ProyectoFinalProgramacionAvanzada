package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.CheckoutProductDTO;
import lombok.*;

import javax.persistence.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "checkouts_products")
public class CheckoutProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Product product;

    @Column
    private Long quantity;

    public CheckoutProductDTO toDTO() {
        return CheckoutProductDTO.builder()
                .id(id)
                .product(product.toDTO())
                .quantity(quantity)
                .build();
    }
}
