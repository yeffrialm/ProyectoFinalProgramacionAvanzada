package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.Command;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreatePaymentMethodCommand extends Command<CreatePaymentMethodResponse> {

    private String name;
    private String description;

    public PaymentMethod toPaymentMethod() {
        return PaymentMethod.builder()
                .name(name)
                .description(description)
                .build();
    }

}