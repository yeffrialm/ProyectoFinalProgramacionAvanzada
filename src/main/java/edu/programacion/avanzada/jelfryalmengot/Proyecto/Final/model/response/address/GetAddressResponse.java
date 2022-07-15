package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.AddressDTO;
import lombok.*;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class GetAddressResponse {


    private List<AddressDTO> addresses;


}
