package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment;

import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeletePaymentMethodRequest {

    private Long id;
}
