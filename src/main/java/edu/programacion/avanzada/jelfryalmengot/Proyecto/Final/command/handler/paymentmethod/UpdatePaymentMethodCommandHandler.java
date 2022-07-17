package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.paymentmethod;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.UpdatePaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.UpdatePaymentMethodResponse;
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
@CommandEvent(command = UpdatePaymentMethodCommand.class)
@Slf4j

public class UpdatePaymentMethodCommandHandler implements CommandHandler<UpdatePaymentMethodResponse, UpdatePaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public UpdatePaymentMethodResponse handle(UpdatePaymentMethodCommand updatePaymentMethodCommand) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(updatePaymentMethodCommand.getId()).orElseThrow();
        paymentMethod.setName(updatePaymentMethodCommand.getName());
        paymentMethod.setDescription(updatePaymentMethodCommand.getDescription());
        paymentMethodRepository.save(paymentMethod);
        log.info("PaymentMethod {} updated", updatePaymentMethodCommand.getId());
         return UpdatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethod.toDTO())
                .build();
    }
}