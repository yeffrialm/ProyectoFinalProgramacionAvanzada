package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout;

import lombok.*;

import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutAddProductRequest {

    private UUID id;

    private Long product;

    private Long quantity;
}
