package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.Conversions;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.ProductState;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.network.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author aluis on 6/12/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String nombre_producto;

    @Column
    private Integer cantidad;

    @Column
    private Boolean disponible;

    @Column
    private BigDecimal precio;



    /**
     * Conversión del enum para la DB en un número
     */
    @Convert(converter = Conversions.ProductStateConverter.class)
    @Column
    private ProductState state;

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
    public ProductDTO toDTO() {
        return ProductDTO.builder()
                .id(id)
                .nombre_producto(nombre_producto)
                .cantidad(cantidad)
                .disponible(disponible)
                .precio(precio)
                .build();
    }

    public void applyChanges(UpdateProductRequest updateProductRequest) {
        this.nombre_producto = updateProductRequest.getNombreProducto();
        this.cantidad = updateProductRequest.getcantidad();
        this.disponible = updateProductRequest.getDisponible();
        this.precio = updateProductRequest.getPrecio();
    }
}
