package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.CreatePaymentMethodCommand;
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

    public CreatePaymentMethodCommand toCommand() {
        return CreatePaymentMethodCommand.builder()
                .name(name)
                .description(description)
                .build();


    }
}
