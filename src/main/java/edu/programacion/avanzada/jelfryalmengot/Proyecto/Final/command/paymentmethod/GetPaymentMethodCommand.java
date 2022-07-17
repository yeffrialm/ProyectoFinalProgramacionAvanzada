package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.GetPaymentMethodResponse;
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

public class GetPaymentMethodCommand extends Command<GetPaymentMethodResponse> {

    private Long id;

}