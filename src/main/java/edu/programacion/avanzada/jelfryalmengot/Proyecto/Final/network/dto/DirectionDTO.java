package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.network.dto;

import lombok.*;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.DirectionState;
import javax.persistence.Column;
import java.math.BigDecimal;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class DirectionDTO {

    private Long id;

    private String principal;

    private String secundaria;

    private Long telefono;

    /**
     * Ejemplo de un enum con @JsonValue
     */
    private DirectionState state;
}
