package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.product;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.product.UpdateProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Product;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product.UpdateProductResponse;
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
@CommandEvent(command = UpdateProductCommand.class)
@Slf4j

public class UpdateProductCommandHandler implements CommandHandler<UpdateProductResponse, UpdateProductCommand> {

    private final ProductRepository productRepository;

    @Override
    public UpdateProductResponse handle(UpdateProductCommand updateProductCommand) {
        Product product = productRepository.findById(updateProductCommand.getId()).orElseThrow();
        product.setDescription(updateProductCommand.getDescription());
        product.setPrice(updateProductCommand.getPrice());
        product.setAvailableQuantity(updateProductCommand.getAvailableQuantity());
        productRepository.save(product);
        log.info("Product {} updated", updateProductCommand.getId());
         return UpdateProductResponse.builder()
                .product(product.toDTO())
                .build();
    }
}