package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address;

import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class UpdateAddressRequest {

    private Long id;
    private String main;
    private String secondary;
    private Long telephone;


}
