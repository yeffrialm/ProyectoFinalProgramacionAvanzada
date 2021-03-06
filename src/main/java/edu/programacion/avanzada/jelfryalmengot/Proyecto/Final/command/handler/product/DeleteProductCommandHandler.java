package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.product;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.DeleteAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = DeleteAddressCommand.class)
@Slf4j

public class DeleteProductCommandHandler implements CommandHandler<DeleteAddressResponse, DeleteAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public DeleteAddressResponse handle(DeleteAddressCommand deleteAddressCommand) {
        addressRepository.deleteById(deleteAddressCommand.getId());
        log.info("Address {} deleted", deleteAddressCommand.getId());
         return DeleteAddressResponse.builder()
                .build();
    }
}