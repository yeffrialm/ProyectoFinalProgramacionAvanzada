package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.network.response;

import edu.aluismarte.diplomado.project.week9.network.dto.EmployeeDTO;
import lombok.*;

/**
 * @author aluis on 6/26/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateDirectionResponse {

    private EmployeeDTO employee;
}
