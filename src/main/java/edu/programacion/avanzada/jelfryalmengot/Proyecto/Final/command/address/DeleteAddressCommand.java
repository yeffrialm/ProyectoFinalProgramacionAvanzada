package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.DeleteAddressResponse;
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

public class DeleteAddressCommand extends Command<DeleteAddressResponse> {

    private long id;

}