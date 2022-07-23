package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkoutproduct;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.CheckoutProductDTO;
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
public class GetCheckoutProductResponse {

    private List<CheckoutProductDTO> checkoutProducts;
}
