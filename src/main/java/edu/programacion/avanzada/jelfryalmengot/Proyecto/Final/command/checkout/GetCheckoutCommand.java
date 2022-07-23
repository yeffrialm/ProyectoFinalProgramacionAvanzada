package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.GetAddressResponse;
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

public class GetCheckoutCommand extends Command<GetAddressResponse> {

    private Long id;

}