package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.address;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.address.CreateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.Command;
import lombok.*;
/**
 * @author jelfry on 7/09/2022.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateAddressCommand  extends Command<CreateAddressResponse> {

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