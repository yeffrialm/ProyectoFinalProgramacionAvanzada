package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.GetCheckoutResponse;
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

public class GetAllCheckoutCommand extends Command<GetCheckoutResponse> {


}