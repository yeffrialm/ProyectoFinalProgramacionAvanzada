package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.product;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.ProductDTO;
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

public class GetProductResponse {


    private List<ProductDTO> products;


}
