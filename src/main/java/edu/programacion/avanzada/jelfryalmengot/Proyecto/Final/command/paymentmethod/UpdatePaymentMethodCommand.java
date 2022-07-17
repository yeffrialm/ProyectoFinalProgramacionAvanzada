package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.UpdatePaymentMethodResponse;
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

public class UpdatePaymentMethodCommand extends Command<UpdatePaymentMethodResponse> {

    private Long id;
    private String name;
    private String description;


}