package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.checkout;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkoutproduct.GetAllCheckoutProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.CheckoutProduct;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.CheckoutProductDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkoutproduct.GetCheckoutProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.CheckoutProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllCheckoutProductCommand.class)
@Slf4j

public class GetAllCheckoutCommandHandler implements CommandHandler<GetCheckoutProductResponse, GetAllCheckoutProductCommand> {

    private final CheckoutProductRepository checkoutProductRepository;

    @Override
    public GetCheckoutProductResponse handle(GetAllCheckoutProductCommand getAllCheckoutProductCommand) {
        log.debug("Get CheckoutProducts {}", getAllCheckoutProductCommand.toString());
        List<CheckoutProductDTO> checkoutproductDTOS = checkoutProductRepository.findAll().stream().map(CheckoutProduct::toDTO).collect(Collectors.toList());
        return GetCheckoutProductResponse.builder()
                .checkoutProducts(checkoutproductDTOS)
                .build();
    }
}