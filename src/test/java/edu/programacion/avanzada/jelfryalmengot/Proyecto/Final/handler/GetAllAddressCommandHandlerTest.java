package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.GetAllAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.address.GetAllAddressCommandHandler;
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

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jelfry on 7/09/2022.
 */
@SpringBootTest
class GetAllAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void getAllAddressTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setMain("Hello");
        addressMock.setSecondary("");
        addressMock.setTelephone(127894561L);
        GetAllAddressCommand getAllAddressCommand = GetAllAddressCommand.builder()
                .main("")
                .pageSize(10)
                .page(0)
                .build();
        Mockito.when(addressRepository.findAllByNameContainingIgnoreCase(ArgumentMatchers.anyString(), ArgumentMatchers.any())).thenReturn(List.of(addressMock));
        GetAllAddressCommandHandler getAllAddressCommandHandler = new GetAllAddressCommandHandler(addressRepository);
        GetAddressResponse getAddressResponse = getAllAddressCommandHandler.handle(getAllAddressCommand);
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