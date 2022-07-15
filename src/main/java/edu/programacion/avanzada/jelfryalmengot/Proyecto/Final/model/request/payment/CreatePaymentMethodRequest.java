package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodRequest {

    private String name;
    private String description;

    public PaymentMethod toPaymentMethod() {
        return PaymentMethod.builder()
                .name(name)
                .description(description)
                .build();
    }
}
