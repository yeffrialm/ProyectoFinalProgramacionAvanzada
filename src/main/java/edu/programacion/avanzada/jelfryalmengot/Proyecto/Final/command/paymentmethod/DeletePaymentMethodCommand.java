package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.DeletePaymentMethodResponse;
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

public class DeletePaymentMethodCommand extends Command<DeletePaymentMethodResponse> {

    private long id;

}