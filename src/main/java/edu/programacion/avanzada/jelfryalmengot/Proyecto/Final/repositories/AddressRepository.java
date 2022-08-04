package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findAllByNameContainingIgnoreCase(String main, Pageable pageable);
}
