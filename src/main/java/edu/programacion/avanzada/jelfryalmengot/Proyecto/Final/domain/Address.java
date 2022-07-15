package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.AddressDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address.UpdateAddressRequest;
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
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String main;

    @Column
    private String secondary;

    @Column
    private Long telephone;

    /**
     * Patrón más integrado y adecuado en la lógica, cada objeto se hace responsable de sus conversiones
     *
     * @return Modelo DTO del Address
     */
    public AddressDTO toDTO() {
        return AddressDTO.builder()
                .id(id)
                .main(main)
                .secondary(secondary)
                .telephone(telephone)
                .build();
    }

    public void applyChanges(UpdateAddressRequest updateAddressRequest) {
        main = updateAddressRequest.getMain();
        secondary = updateAddressRequest.getSecondary();
        telephone = updateAddressRequest.getTelephone();
    }
}
