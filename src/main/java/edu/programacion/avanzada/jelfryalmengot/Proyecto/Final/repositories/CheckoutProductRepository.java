package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.CheckoutProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jelfry on 7/09/2022.
 */
@Repository
public interface CheckoutProductRepository extends JpaRepository<CheckoutProduct, Long> {
}
