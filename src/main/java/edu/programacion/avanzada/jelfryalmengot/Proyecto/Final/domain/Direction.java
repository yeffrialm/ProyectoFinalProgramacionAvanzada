package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;

import


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.Conversions;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.DirectionState;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.network.dto.DirectionDTO;
import lombok.*;

import javax.persistence.*;

/**
 * @author aluis on 6/12/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Direction")
public class Direction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String principal;

    @Column
    private String secundaria;

    @Column
    private Long telefono;

    /**
     * Conversión del enum para la DB en un número
     */
    @Convert(converter = Conversions.DirectionStateConverter.class)
    @Column
    private DirectionState state;

    // Audit Fields, no es necesario exponer esto en la API
    //verificar si hay que agregarle otro string o variable para telefono

    @Column
    private String createdBy;
    @Column
    private String updatedBy;


    /**
     * Patrón más integrado y adecuado en la lógica, cada objeto se hace responsable de sus conversiones
     *
     * @return Modelo DTO del Direction
     */
    public DirectionDTO toDTO() {
        return DirectionDTO.builder()
                .id(id)
                .principal(principal)
                .secundaria(secundaria)
                .telefono(telefono)
                .build();
    }

    public void applyChanges(UpdateDirectionRequest updateDirectionRequest) {
        this.principal = updateDirectionRequest.getPrincipal();
        this.secundaria = updateDirectionRequest.getSecundaria();
        this.telefono = updateDirectionRequest.getTelefono();
    }
}
