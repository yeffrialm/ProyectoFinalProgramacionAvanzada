package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.DirectionState;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.ProductState;

import javax.persistence.AttributeConverter;

/**
 * Mostrar como los ENUM pueden ser maleables para la DB y los request, manteniendo el código simple y elegante
 * <p>
 * Facilidades del ENUM
 * - Permite al programador trabajar siempre tipado
 * - La visualización del ENUM puede ajustar en los JSON y en la DB
 *
 * @author aluis on 6/4/2022.
 * @implNote Para más detalles de la serialización por JSON edu.aluismarte.diplomado.project.week11.dto.EmployeeDTOTest
 * @implNote Para ver la estructura en H2 usamos "show columns from EMPLOYEES;"
 * @see <a href="http://localhost:8080/h2-console">Conexion DB</a>
 */
public class Conversions {

    public static class DirectionStateConverter implements AttributeConverter<DirectionState, Integer> {
        @Override
        public Integer convertToDatabaseColumn(DirectionState attribute) {
            if (attribute == null) {
                return null;
            }
            return attribute.getCode();
        }

        @Override
        public DirectionState convertToEntityAttribute(Integer dbData) {
            if (dbData == null) {
                return null;
            }
            return DirectionState.fromCode(dbData);
        }
    }

    public static class ProductStateConverter implements AttributeConverter<ProductState, Integer> {
        @Override
        public Integer convertToDatabaseColumn(ProductState attribute) {
            if (attribute == null) {
                return null;
            }
            return attribute.getCode();
        }

        @Override
        public ProductState convertToEntityAttribute(Integer dbData) {
            if (dbData == null) {
                return null;
            }
            return ProductState.fromCode(dbData);
        }
    }
}
