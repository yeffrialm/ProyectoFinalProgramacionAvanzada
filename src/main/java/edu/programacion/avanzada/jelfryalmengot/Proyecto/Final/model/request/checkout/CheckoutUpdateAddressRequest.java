package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.checkout;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.CheckoutUpdateAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
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
public class CheckoutUpdateAddressRequest {

    private UUID id;

    private Address address;

    public CheckoutUpdateAddressCommand toCommand() {
        return CheckoutUpdateAddressCommand.builder()
                .address(address)
                .build();
    }

}