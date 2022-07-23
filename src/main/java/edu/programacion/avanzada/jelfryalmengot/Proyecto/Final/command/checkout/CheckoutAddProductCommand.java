package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.CheckoutProductDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutAddProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.Command;
import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CheckoutAddProductCommand extends Command<CheckoutAddProductResponse> {

    private UUID id;
    private List<CheckoutProductDTO> productsToBuy;

// esta parte esta conectada a checkoutproduct, verificar para hacerla funcionar

    public CheckoutAddProductCommand toCommand() {
        return CheckoutAddProductCommand.builder()
                .id(id)
                .productsToBuy(productsToBuy)
                .build();
    }

}