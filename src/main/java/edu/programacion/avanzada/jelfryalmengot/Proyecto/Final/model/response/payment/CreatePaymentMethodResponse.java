package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.PaymentMethodDTO;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodResponse {

    private PaymentMethodDTO paymentMethod;
}
