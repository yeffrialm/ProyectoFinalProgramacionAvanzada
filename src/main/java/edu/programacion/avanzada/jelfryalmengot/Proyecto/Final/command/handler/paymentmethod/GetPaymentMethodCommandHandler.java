package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.paymentmethod;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.GetPaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetPaymentMethodCommand.class)
@Slf4j

public class GetPaymentMethodCommandHandler implements CommandHandler<GetPaymentMethodResponse, GetPaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public GetPaymentMethodResponse handle(GetPaymentMethodCommand getPaymentMethodCommand) {
        log.debug("Get PaymentMethod {}", getPaymentMethodCommand.getId());
        PaymentMethodDTO paymentMethodDTO = paymentMethodRepository.findById(getPaymentMethodCommand.getId()).orElseThrow().toDTO();
        return GetPaymentMethodResponse.builder()
                .paymentMethods(List.of(paymentMethodDTO))
                .build();
    }
}