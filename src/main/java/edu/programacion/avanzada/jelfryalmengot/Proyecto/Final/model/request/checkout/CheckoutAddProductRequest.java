package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.CheckoutAddProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.CheckoutProduct;
import lombok.*;

import java.util.List;
import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutAddProductRequest {

    private UUID id;

    private List<CheckoutProduct> productsToBuy;

    public CheckoutAddProductCommand toCommand() {
        return CheckoutAddProductCommand.builder()
                //.productsToBuy(productsToBuy)
                .build();
    }
}
