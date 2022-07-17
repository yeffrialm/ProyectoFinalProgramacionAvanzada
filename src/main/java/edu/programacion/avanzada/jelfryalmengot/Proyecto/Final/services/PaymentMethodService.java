package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.GetAllPaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.GetPaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment.CreatePaymentMethodRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment.DeletePaymentMethodRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.DeletePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author jelfry on 7/09/2022.
 */
@Service
@RequiredArgsConstructor
public class PaymentMethodService {

    private final CommandBus commandBus;

    public GetPaymentMethodResponse getAll() {
        return commandBus.sendCommand(GetAllPaymentMethodCommand.builder().build());
    }

    public GetPaymentMethodResponse get(Long id) {
        return commandBus.sendCommand(GetPaymentMethodCommand.builder().id(id).build());
    }

    public CreatePaymentMethodResponse create(CreatePaymentMethodRequest createPaymentMethodRequest) {
        return commandBus.sendCommand(createPaymentMethodRequest.toCommand());
    }

    public UpdatePaymentMethodResponse update(UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return commandBus.sendCommand(updatePaymentMethodRequest.toCommand());
    }

    public DeletePaymentMethodResponse delete (DeletePaymentMethodRequest deletePaymentMethodRequest) {
        return commandBus.sendCommand(deletePaymentMethodRequest.toCommand());
    }
}
