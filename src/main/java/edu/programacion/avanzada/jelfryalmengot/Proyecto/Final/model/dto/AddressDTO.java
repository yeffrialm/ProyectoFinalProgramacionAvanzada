package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto;

import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AddressDTO {

    private Long id;

    private String main;

    private String secondary;

    private Long telephone;

}
