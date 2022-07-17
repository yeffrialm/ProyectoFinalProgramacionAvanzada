package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.product;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product.CreateProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Product;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.CreateProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CreateProductCommand.class)
@Slf4j

public class CreateProductCommandHandler implements CommandHandler<CreateProductResponse, CreateProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public CreateProductResponse handle(CreateProductCommand createProductCommand) {
        Product product = productRepository.save(createProductCommand.toProduct());
        log.info("Product {} created", product.getId());
         return CreateProductResponse.builder()
                .product(product.toDTO())
                .build();
    }
}