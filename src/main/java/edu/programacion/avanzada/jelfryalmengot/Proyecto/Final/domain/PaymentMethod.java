package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment.UpdatePaymentMethodRequest;
import lombok.*;

import javax.persistence.*;


/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "payment_methods")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    /**
     * Patrón más integrado y adecuado en la lógica, cada objeto se hace responsable de sus conversiones
     *
     * @return Modelo DTO del paymentMethod
     */
    public PaymentMethodDTO toDTO() {
        return PaymentMethodDTO.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

    public void applyChanges(UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        description = updatePaymentMethodRequest.getDescription();
    }

}