package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.product;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product.GetProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.ProductDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.GetProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetProductCommand.class)
@Slf4j

public class GetProductCommandHandler implements CommandHandler<GetProductResponse, GetProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public GetProductResponse handle(GetProductCommand getProductCommand) {
        log.debug("Get Product {}", getProductCommand.getId());
        ProductDTO productDTO = productRepository.findById(getProductCommand.getId()).orElseThrow().toDTO();
        return GetProductResponse.builder()
                .products(List.of(productDTO))
                .build();
    }
}