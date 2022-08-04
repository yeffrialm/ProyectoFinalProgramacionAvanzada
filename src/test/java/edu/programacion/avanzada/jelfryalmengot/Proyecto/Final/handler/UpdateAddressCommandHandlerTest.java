package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address.UpdateAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.address.UpdateAddressCommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.AddressDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions.AddressNoFoundException;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jelfry on 7/09/2022.
 */
@SpringBootTest
class UpdateAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void updateAddressTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setMain("Hello");
        addressMock.setSecondary("world");
        addressMock.setTelephone(789456123L);
        UpdateAddressCommand createAddressCommand = UpdateAddressCommand.builder()
                .id(1L)
                .secondary("OMG")
                .telephone(145678912L)
                .build();
        Mockito.when(addressRepository.findById(ArgumentMatchers.eq(1L))).thenReturn(Optional.of(addressMock));
        UpdateAddressCommandHandler updateAddressCommandHandler = new UpdateAddressCommandHandler(addressRepository);
        UpdateAddressResponse updateAddressResponse = updateAddressCommandHandler.handle(createAddressCommand);
        assertNotNull(updateAddressResponse);
        AddressDTO address = updateAddressResponse.getAddress();
        assertEquals(addressMock.getId(), address.getId());
        assertEquals(addressMock.getMain(), address.getMain());
        assertEquals(createAddressCommand.getSecondary(), address.getSecondary());
        assertEquals(createAddressCommand.getTelephone(), address.getTelephone());
    }

    @Test
    void updateAddressNoFoundTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setMain("Hello");
        addressMock.setSecondary("");
        UpdateAddressCommand createAddressCommand = UpdateAddressCommand.builder()
                .id(2L)
                .secondary("OMG")
                .build();
        Mockito.when(addressRepository.findById(ArgumentMatchers.eq(1L))).thenReturn(Optional.of(addressMock));
        UpdateAddressCommandHandler updateAddressCommandHandler = new UpdateAddressCommandHandler(addressRepository);
        assertThrows(AddressNoFoundException.class, () -> {
            UpdateAddressResponse updateAddressResponse = updateAddressCommandHandler.handle(createAddressCommand);
            assertNotNull(updateAddressResponse);
        });
    }

}