package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStep;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepCompensator;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.handler.PayCheckoutSaveOrderHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jelfry on 7/09/2022.
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class PayCheckoutSaveOrderStep implements SagaStep<PayCheckoutResponse> {

    private final PayCheckoutSaveOrderHandler payCheckoutSaveOrderHandler;

    @Override
    public String getName() {
        return "Save Order";
    }

    @Override
    public SagaStepHandler<PayCheckoutResponse> getHandler() {
        return payCheckoutSaveOrderHandler;
    }

    @Override
    public SagaStepCompensator<PayCheckoutResponse> getCompensator() {
        return null;
    }
}
