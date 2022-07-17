package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.Command;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jelfry on 7/09/2022.
 */
@Builder
@AllArgsConstructor
@Getter
@Setter

public class GetAllPaymentMethodCommand extends Command<GetPaymentMethodResponse> {


}