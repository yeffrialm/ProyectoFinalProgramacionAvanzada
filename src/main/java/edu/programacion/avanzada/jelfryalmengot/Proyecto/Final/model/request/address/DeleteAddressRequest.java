package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.DeleteAddressCommand;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class DeleteAddressRequest {

    private long id;

    public DeleteAddressCommand toCommand() {
        return DeleteAddressCommand.builder()
                .id(id)
                .build();
    }

}
