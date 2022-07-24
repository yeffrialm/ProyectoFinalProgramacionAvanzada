package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.CreateProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.Saga;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step.SagaCreateProductResponseStep1;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step.SagaCreateProductResponseStep2;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step.SagaCreateProductResponseStepFinal;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step.SagaCreateProductResponseStepTrueFinal;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SagaFactory {
    public static Saga<CreateProductResponse> createProductSaga(UUID key, CreateProductResponse command) {
        SagaPayload<CreateProductResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(new SagaPayLoadKey<>("command", CreateProductResponse.class), command);
        return Saga.<CreateProductResponse>builder()
                .name("Create Product Saga")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        SagaCreateProductResponseStep1.class,
                        SagaCreateProductResponseStep2.class,
                        SagaCreateProductResponseStepFinal.class,
                        SagaCreateProductResponseStepTrueFinal.class
                ))
                .build();
    }
}
