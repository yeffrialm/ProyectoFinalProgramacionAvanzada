package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.handler;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Checkout;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.exceptions.CheckoutNoFoundException;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaStepHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PayCheckoutFindDataHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final CheckoutRepository checkoutRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        PayCheckoutCommand command = sagaPayload.getProperty(PayCheckoutCommand.COMMAND);
        Checkout checkout = checkoutRepository.findById(command.getId()).orElseThrow(() -> new CheckoutNoFoundException(command.getId()));

        sagaPayload.addProperty(PayCheckoutCommand.CHECKOUT, checkout);
    }
}
