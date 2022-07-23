package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkoutproduct;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkoutproduct.GetCheckoutProductResponse;
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

public class GetCheckoutProductCommand extends Command<GetCheckoutProductResponse> {

    private Long id;

}