package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.controller;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.DeleteAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.GetAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.UpdateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<GetAddressResponse> get() {
        return ResponseEntity.ok(GetAddressResponse.builder()
                .addresses(addressService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(GetAddressResponse.builder()
                .addresses(List.of(addressService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@RequestBody CreateAddressRequest createAddressRequest) {
        return ResponseEntity.ok(CreateAddressResponse.builder()
                .address(addressService.create(createAddressRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponse> update(@RequestBody UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(UpdateAddressResponse.builder()
                .address(addressService.update(updateAddressRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponse> delete(@RequestBody DeleteAddressRequest deleteAddressRequest) {
        addressService.delete(deleteAddressRequest);
        return ResponseEntity.ok(DeleteAddressResponse.builder().build());
    }
}
