package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author aluis on 6/12/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "PaymentMethods")
public class PaymentMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nombre_metodo;

    /**
     * Conversión del enum para la DB en un número
     */
    @Convert(converter = Conversions.PaymentMethodsStateConverter.class)
    @Column
    private PaymentMethodsState state;

    // Audit Fields, no es necesario exponer esto en la API
    //verificar si hay que agregarle otro string o variable para los demas que faltan

    @Column
    private String createdBy;
    @Column
    private String updatedBy;


    /**
     * Patrón más integrado y adecuado en la lógica, cada objeto se hace responsable de sus conversiones
     *
     * @return Modelo DTO del Direction
     */
    public PaymentMethodsDTO toDTO() {
        return PaymentMethodsDTO.builder()
                .id(id)
                .nombre_metodo(nombre_metodo)
                .build();
    }

    public void applyChanges(UpdatePaymentMethodsRequest updateProductRequest) {
        this.nombre_metodo = updatePaymentMethodsRequest.getNombreMetodo();

    }
}
