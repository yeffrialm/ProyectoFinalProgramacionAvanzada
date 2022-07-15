package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author jelfry on 7/09/2022.
 */
@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, UUID> {
}
