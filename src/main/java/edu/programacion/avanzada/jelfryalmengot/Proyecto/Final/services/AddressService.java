package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.GetAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.GetAllAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jelfry on 7/09/2022.
 */
@Service
@RequiredArgsConstructor

public class AddressService {

    private final CommandBus commandBus;

    public GetAddressResponse getAll() {
        return commandBus.sendCommand(GetAllAddressCommand.builder().build());
    }

    public GetAddressResponse get(Long id) {
        return commandBus.sendCommand(GetAddressCommand.builder().id(id).build());
    }

    public CreateAddressResponse create(CreateAddressRequest createAddressRequest) {
        return commandBus.sendCommand(createAddressRequest.toCommand());
    }

    public UpdateAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        return commandBus.sendCommand(updateAddressRequest.toCommand());
    }

    public DeleteAddressResponse delete (DeleteAddressRequest deleteAddressRequest) {
        return commandBus.sendCommand(deleteAddressRequest.toCommand());
    }

}
