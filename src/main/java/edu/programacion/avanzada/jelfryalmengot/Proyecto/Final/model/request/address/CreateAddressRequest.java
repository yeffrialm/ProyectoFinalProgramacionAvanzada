package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.address;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class CreateAddressRequest {


    private String main;
    private String secondary;
    private Long telephone;


    public Address toAddress() {
        return Address.builder()
                .main(main)
                .secondary(secondary)
                .telephone(telephone)
                .build();
    }
}
