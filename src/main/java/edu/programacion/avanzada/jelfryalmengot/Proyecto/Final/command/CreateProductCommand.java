package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.CreateProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.Command;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateProductCommand extends Command<CreateProductResponse> {

    private boolean explote;
}
