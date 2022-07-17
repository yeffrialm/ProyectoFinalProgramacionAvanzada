package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.paymentmethod;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.GetAllPaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.dto.PaymentMethodDTO;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllPaymentMethodCommand.class)
@Slf4j

public class GetAllPaymentMethodCommandHandler implements CommandHandler<GetPaymentMethodResponse, GetAllPaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public GetPaymentMethodResponse handle(GetAllPaymentMethodCommand getAllPaymentMethodCommand) {
        log.debug("Get PaymentMethods {}", getAllPaymentMethodCommand.toString());
        List<PaymentMethodDTO> PaymentMethodDTOS = paymentMethodRepository.findAll().stream().map(PaymentMethod::toDTO).collect(Collectors.toList());
        return GetPaymentMethodResponse.builder()
                .paymentMethods(PaymentMethodDTOS)
                .build();
    }
}