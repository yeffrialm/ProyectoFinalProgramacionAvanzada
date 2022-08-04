package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.GetAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.address.GetAddressCommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.AddressDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jelfry on 7/09/2022.
 */
@SpringBootTest
class GetAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void getAddressTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setMain("Hello");
        addressMock.setSecondary("");
        addressMock.setTelephone(8092254556L);
        GetAddressCommand getAddressCommand = GetAddressCommand.builder().id(addressMock.getId()).build();
        Mockito.when(addressRepository.findById(ArgumentMatchers.eq(1L))).thenReturn(Optional.of(addressMock));
        GetAddressCommandHandler getAddressCommandHandler = new GetAddressCommandHandler(addressRepository);
        GetAddressResponse getAddressResponse = getAddressCommandHandler.handle(getAddressCommand);
        assertNotNull(getAddressResponse);
        List<AddressDTO> addresses = getAddressResponse.getAddresses();
        assertNotNull(addresses);
        assertFalse(addresses.isEmpty());
        assertEquals(1, addresses.size());
        AddressDTO address = addresses.get(0);
        assertEquals(addressMock.getId(), address.getId());
        assertEquals(addressMock.getMain(), address.getMain());
        assertEquals(addressMock.getSecondary(), address.getSecondary());
        assertEquals(addressMock.getTelephone(), address.getTelephone());
    }

}