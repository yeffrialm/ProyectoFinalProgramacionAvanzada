package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.handler.PayCheckoutFindDataHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class PayCheckoutFindDataStep implements SagaStep<PayCheckoutResponse> {

    private final PayCheckoutFindDataHandler payCheckoutFindDataHandler;

    @Override
    public String getName() {
        return "Find Data";
    }

    @Override
    public SagaStepHandler<PayCheckoutResponse> getHandler() {
        return payCheckoutFindDataHandler;
    }

    @Override
    public SagaStepCompensator<PayCheckoutResponse> getCompensator() {
        return null;
    }
}