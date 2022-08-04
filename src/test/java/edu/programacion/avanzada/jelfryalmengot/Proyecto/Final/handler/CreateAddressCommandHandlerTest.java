package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.CreateAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.address.CreateAddressCommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.AddressDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author jelfry on 7/09/2022.
 */
@SpringBootTest
class CreateAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void createAddressTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setMain("Hello");
        addressMock.setSecondary("world");
        addressMock.setTelephone(789456123L);
        CreateAddressCommand createAddressCommand = CreateAddressCommand.builder()
                .main(addressMock.getMain())
                .secondary(addressMock.getSecondary())
                .telephone(addressMock.getTelephone())
                .build();
        Mockito.when(addressRepository.save(ArgumentMatchers.any())).thenReturn(addressMock);
        CreateAddressCommandHandler createAddressCommandHandler = new CreateAddressCommandHandler(addressRepository);
        CreateAddressResponse createAddressResponse = createAddressCommandHandler.handle(createAddressCommand);
        assertNotNull(createAddressResponse);
        AddressDTO address = createAddressResponse.getAddress();
        assertEquals(addressMock.getId(), address.getId());
        assertEquals(addressMock.getMain(), address.getMain());
        assertEquals(addressMock.getSecondary(), address.getSecondary());
        assertEquals(addressMock.getTelephone(), address.getTelephone());
    }
}