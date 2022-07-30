package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.OrderDTO;
import lombok.*;

/**
 * @author jelfry on 7/09/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutResponse {

    private OrderDTO orderDTO;
}
