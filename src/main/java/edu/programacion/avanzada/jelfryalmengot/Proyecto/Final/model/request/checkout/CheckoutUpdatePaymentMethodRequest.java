package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.CheckoutUpdatePaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
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
public class CheckoutUpdatePaymentMethodRequest {

    private UUID id;

    private PaymentMethod paymentMethod;

    public CheckoutUpdatePaymentMethodCommand toCommand() {
        return CheckoutUpdatePaymentMethodCommand.builder()
                .paymentMethod(paymentMethod)
                .build();
    }

}
