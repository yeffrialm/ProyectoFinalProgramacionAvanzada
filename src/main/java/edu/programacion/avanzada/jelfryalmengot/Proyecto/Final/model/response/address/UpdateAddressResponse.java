package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.AddressDTO;
import lombok.*;


/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class UpdateAddressResponse {

    private AddressDTO address;
}
