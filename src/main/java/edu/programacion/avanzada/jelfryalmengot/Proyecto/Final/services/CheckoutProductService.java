package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkoutproduct.GetAllCheckoutProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkoutproduct.GetCheckoutProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkoutproduct.GetCheckoutProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jelfry on 7/09/2022.
 */
@Service
@RequiredArgsConstructor
public class CheckoutProductService {

    private final CommandBus commandBus;

    public GetCheckoutProductResponse getAll() {

        return commandBus.sendCommand(GetAllCheckoutProductCommand.builder().build());
    }

    public GetCheckoutProductResponse get(Long id) {
        return commandBus.sendCommand(GetCheckoutProductCommand.builder().id(id).build());
    }

}