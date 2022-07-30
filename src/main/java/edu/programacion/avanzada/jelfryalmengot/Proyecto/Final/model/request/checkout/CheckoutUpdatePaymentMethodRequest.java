package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout;

import lombok.*;

import java.util.UUID;

/**
 * @author aluis on 7/10/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutUpdatePaymentMethodRequest {

    private UUID id;

    private Long paymentMethod;
}
