package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.DeleteAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.address.DeleteAddressCommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author jelfry on 7/09/2022.
 */
@SpringBootTest
class DeleteAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void deleteAddressTest() {
        DeleteAddressCommand deleteAddressCommand = DeleteAddressCommand.builder()
                .id(1L)
                .build();
        Mockito.doNothing().when(addressRepository).deleteById(ArgumentMatchers.eq(1L));
        DeleteAddressCommandHandler deleteAddressCommandHandler = new DeleteAddressCommandHandler(addressRepository);
        DeleteAddressResponse deleteAddressResponse = deleteAddressCommandHandler.handle(deleteAddressCommand);
        assertNotNull(deleteAddressResponse);
    }

}