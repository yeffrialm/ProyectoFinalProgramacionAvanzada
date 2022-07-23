package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.CheckoutProduct;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutUpdatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.Command;
import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CheckoutUpdatePaymentMethodCommand extends Command<CheckoutUpdatePaymentMethodResponse> {

    private UUID id;
    private Address address;
    private PaymentMethod paymentMethod;
    private List<CheckoutProduct> productsToBuy;
}