package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.CheckoutDTO;
import lombok.*;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetCheckoutResponse {

    private List<CheckoutDTO> checkouts;
}
