package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.controllers;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.controller.AddressController;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.CreateAddressRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

/**
 * @author jelfry on 7/09/2022.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {

    @Autowired
    private AddressController addressController;

    @Test
    void checkCreateAddressRequestTest() {
        CreateAddressRequest createAddressRequest = CreateAddressRequest.builder()
                .main(null)
                .build();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            try {
                addressController.create(createAddressRequest);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        });
    }

    @Test
    void checkCreateAddressRequest_minNameSizeTest() {
        CreateAddressRequest createAddressRequest = CreateAddressRequest.builder()
                .main("123")
                .build();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            try {
                addressController.create(createAddressRequest);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        });
    }

    @Test
    void checkCreateAddressRequest_maxNameSizeTest() {
        CreateAddressRequest createAddressRequest = CreateAddressRequest.builder()
                .main("0123456789A")
                .build();
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            try {
                addressController.create(createAddressRequest);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        });
    }

}