package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.order;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.OrderDTO;
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
public class GetOrderResponse {

    private List<OrderDTO> orders;
}
