package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;

import edu.aluismarte.diplomado.project.week9.Conversions;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 * @author aluis on 6/12/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDate fecha;

    @Column
    private BigDecimal total_factura;

// crear las columnas con la relacion de los productos y metodos de pagos



    /**
     * Conversión del enum para la DB en un número
     */
    @Convert(converter = Conversions.BillStateConverter.class)
    @Column
    private BillState state;

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
    public BillDTO toDTO() {
        return BillDTO.builder()
                .id(id)
                .fecha(fecha)
                .total_factura(total_factura)
//agregar los elementos de producto y metodos de pago
                .build();
    }

    public void applyChanges(UpdateBillRequest updateBillRequest) {
        this.fecha = updateBillRequest.getFecha();
        this.total_factura = updateBillRequest.getTotalFactura();
//agregar los elementos de producto y metodos de pago
    }
}
