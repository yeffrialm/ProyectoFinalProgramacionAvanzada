package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.paymentmethod;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.paymentmethod.DeletePaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.DeletePaymentMethodResponse;
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
@CommandEvent(command = DeletePaymentMethodCommand.class)
@Slf4j

public class DeletePaymentMethodCommandHandler implements CommandHandler<DeletePaymentMethodResponse, DeletePaymentMethodCommand> {

    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public DeletePaymentMethodResponse handle(DeletePaymentMethodCommand deletePaymentMethodCommand) {
        paymentMethodRepository.deleteById(deletePaymentMethodCommand.getId());
        log.info("PaymentMethod {} deleted", deletePaymentMethodCommand.getId());
         return DeletePaymentMethodResponse.builder()
                .build();
    }
}