package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.address;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.UpdateAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.UpdateAddressResponse;
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
@CommandEvent(command = UpdateAddressCommand.class)
@Slf4j

public class UpdateAddressCommandHandler implements CommandHandler<UpdateAddressResponse, UpdateAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public UpdateAddressResponse handle(UpdateAddressCommand updateAddressCommand) {
        Address address = addressRepository.findById(updateAddressCommand.getId()).orElseThrow();
        address.setMain(updateAddressCommand.getMain());
        address.setSecondary(updateAddressCommand.getSecondary());
        address.setTelephone(updateAddressCommand.getTelephone());
        addressRepository.save(address);
        log.info("Address {} updated", updateAddressCommand.getId());
         return UpdateAddressResponse.builder()
                .address(address.toDTO())
                .build();
    }
}