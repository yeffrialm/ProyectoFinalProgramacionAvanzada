package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkoutproduct;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkoutproduct.GetCheckoutProductResponse;
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

public class GetAllCheckoutProductCommand extends Command<GetCheckoutProductResponse> {


}