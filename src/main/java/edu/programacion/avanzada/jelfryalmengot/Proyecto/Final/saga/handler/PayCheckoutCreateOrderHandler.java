package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Checkout;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.LogEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Order;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.OrderRepository;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services.LogEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class PayCheckoutCreateOrderHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final LogEventService logEventService;
    private OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        UUID id = sagaPayload.getProperty(PayCheckoutCommand.ID);
        PayCheckoutCommand command = sagaPayload.getProperty(PayCheckoutCommand.COMMAND);
        Checkout checkout = sagaPayload.getProperty(PayCheckoutCommand.CHECKOUT);
        Order order = checkout.toOrder();
      logEventService.save(LogEvent.builder()
                .classOwner(getClass().toString())
                .processId(id)
                .process("Create Order")
                .parameterMap(Map.of("command", command))
                .build());
        sagaPayload.addProperty(PayCheckoutCommand.ORDER, order);

    }
}

