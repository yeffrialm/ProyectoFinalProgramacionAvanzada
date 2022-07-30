package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.PayCheckoutCommand;
import lombok.*;

import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutRequest {


    private UUID id;

    public PayCheckoutCommand toCommand() {
        return PayCheckoutCommand.builder()
                .id(id)
                .build();
    }


}
