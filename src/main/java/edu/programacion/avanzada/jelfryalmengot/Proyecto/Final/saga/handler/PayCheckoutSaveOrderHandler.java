package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Order;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author jelfry on 7/09/2022.
 */
@RequiredArgsConstructor
@Component
public class PayCheckoutSaveOrderHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        Order order = sagaPayload.getProperty(PayCheckoutCommand.ORDER);
        orderRepository.save(order);
    }
}
