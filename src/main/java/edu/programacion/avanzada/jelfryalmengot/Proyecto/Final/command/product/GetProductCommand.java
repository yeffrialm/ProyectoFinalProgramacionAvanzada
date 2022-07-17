package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.GetProductResponse;
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

public class GetProductCommand extends Command<GetProductResponse> {

    private Long id;

}