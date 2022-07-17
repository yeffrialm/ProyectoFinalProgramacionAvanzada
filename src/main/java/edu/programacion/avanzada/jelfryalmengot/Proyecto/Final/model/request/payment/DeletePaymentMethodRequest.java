package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.DeletePaymentMethodCommand;
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

    public DeletePaymentMethodCommand toCommand() {
        return DeletePaymentMethodCommand.builder()
                .id(id)
                .build();
    }

}
