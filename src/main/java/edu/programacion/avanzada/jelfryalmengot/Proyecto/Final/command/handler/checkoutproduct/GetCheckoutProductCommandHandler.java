package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.checkoutproduct;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkoutproduct.GetCheckoutProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.CheckoutProductDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkoutproduct.GetCheckoutProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.CheckoutProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetCheckoutProductCommand.class)
@Slf4j

public class GetCheckoutProductCommandHandler implements CommandHandler<GetCheckoutProductResponse, GetCheckoutProductCommand> {

    private final CheckoutProductRepository checkoutProductRepository;

    @Override
    public GetCheckoutProductResponse handle(GetCheckoutProductCommand getCheckoutProductCommand) {
        log.debug("Get CheckoutProduct {}", getCheckoutProductCommand.getId());
        CheckoutProductDTO checkoutProductDTO = checkoutProductRepository.findById(getCheckoutProductCommand.getId()).orElseThrow().toDTO();
        return GetCheckoutProductResponse.builder()
                .checkoutProducts(List.of(checkoutProductDTO))
                .build();
    }
}