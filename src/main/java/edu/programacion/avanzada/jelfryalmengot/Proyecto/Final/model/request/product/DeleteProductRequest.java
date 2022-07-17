package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.product;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product.DeleteProductCommand;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class DeleteProductRequest {

    private long id;

    public DeleteProductCommand toCommand() {
        return DeleteProductCommand.builder()
                .id(id)
                .build();
    }
}
