package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.UpdatePaymentMethodCommand;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodRequest {

    private Long id;
    private String name;
    private String description;

    public UpdatePaymentMethodCommand toCommand() {
        return UpdatePaymentMethodCommand.builder()
                .name(name)
                .description(description)
                .build();
    }
}
