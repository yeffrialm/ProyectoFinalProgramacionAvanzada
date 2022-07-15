package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.AddressDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.CreateAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.DeleteAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.UpdateAddressRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jelfry on 7/09/2022.
 */
@Service
@RequiredArgsConstructor

public class AddressService {


    private final AddressRepository addressRepository;

    public List<AddressDTO> getAll() {
        return addressRepository.findAll().stream().map(Address::toDTO).collect(Collectors.toList());
    }

    public AddressDTO get(Long id) {
        return addressRepository.findById(id).orElseThrow().toDTO();
    }

    public AddressDTO create(CreateAddressRequest createAddressRequest) {
        Address address = addressRepository.save(createAddressRequest.toAddress());
        return address.toDTO();
    }

    public AddressDTO update(UpdateAddressRequest updateAddressRequest) {
        Address address = addressRepository.findById(updateAddressRequest.getId()).orElseThrow();
        address.applyChanges(updateAddressRequest);
        addressRepository.save(address);
        return address.toDTO();
    }

    public void delete(DeleteAddressRequest deleteAddressRequest) {
        addressRepository.deleteById(deleteAddressRequest.getId());
    }

}
