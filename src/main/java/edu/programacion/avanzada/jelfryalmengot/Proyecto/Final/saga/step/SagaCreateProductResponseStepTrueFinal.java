package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.CreateProductCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions.BadSagaException;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.CreateProductResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaPayLoadKey;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class SagaCreateProductResponseStepTrueFinal implements SagaStep<CreateProductResponse> {

    @Override
    public String getName() {
        return "Demo Step true final";
    }

    @Override
    public SagaStepHandler<CreateProductResponse> getHandler() {
        return sagaPayload -> {
            CreateProductCommand command = sagaPayload.getProperty(new SagaPayLoadKey<>("id", CreateProductCommand.class));
            log.info("Running {} Handler", getName());
            if (command.isExplote()) {
                throw new BadSagaException();
            }
            sagaPayload.setResult(CreateProductResponse.builder().product().build());
        };
    }

    @Override
    public SagaStepCompensator<CreateProductResponse> getCompensator() {
        return null;
    }
}
