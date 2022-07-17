package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.paymentmethod;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.CreatePaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CreatePaymentMethodCommand.class)
@Slf4j

public class CreatePaymentMethodCommandHandler implements CommandHandler<CreatePaymentMethodResponse, CreatePaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public CreatePaymentMethodResponse handle(CreatePaymentMethodCommand createPaymentMethodCommand) {
        PaymentMethod paymentMethod = paymentMethodRepository.save(createPaymentMethodCommand.toPaymentMethod());
        log.info("PaymentMethod {} created", paymentMethod.getId());
         return CreatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethod.toDTO())
                .build();
    }
}