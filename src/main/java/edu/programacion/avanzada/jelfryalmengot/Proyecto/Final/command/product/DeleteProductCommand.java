package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.DeleteProductResponse;
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

public class DeleteProductCommand extends Command<DeleteProductResponse> {

    private long id;

}