package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga;

import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.PayCheckoutCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.PayCheckoutResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.Saga;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model.SagaPayload;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step.PayCheckoutCreateOrderStep;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step.PayCheckoutFindDataStep;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.step.PayCheckoutSaveOrderStep;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SagaFactory {

    public static Saga<PayCheckoutResponse> payCheckoutSaga(UUID key, PayCheckoutCommand command) {
        SagaPayload<PayCheckoutResponse> sagaPayload = new SagaPayload<>();
        sagaPayload.addProperty(PayCheckoutCommand.COMMAND, command);
        return Saga.<PayCheckoutResponse>builder()
                .name("Pay Ckeckout Saga")
                .key(key)
                .payload(sagaPayload)
                .requiredStep(List.of(
                        PayCheckoutFindDataStep.class,
                        PayCheckoutCreateOrderStep.class,
                        PayCheckoutSaveOrderStep.class
                ))
                .build();
    }

}
