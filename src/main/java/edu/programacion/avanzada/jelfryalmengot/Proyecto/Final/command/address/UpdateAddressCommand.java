package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.UpdateAddressResponse;
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

public class UpdateAddressCommand extends Command<UpdateAddressResponse> {

    private Long id;
    private String main;
    private String secondary;
    private Long telephone;

}