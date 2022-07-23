package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.checkout;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.CheckoutUpdatePaymentMethodCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Checkout;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.PaymentMethod;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutUpdatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.CheckoutRepository;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.PaymentMethodRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CheckoutUpdatePaymentMethodCommand.class)
@Slf4j

public class CheckoutUpdatePaymentMethodCommandHandler implements CommandHandler<CheckoutUpdatePaymentMethodResponse, CheckoutUpdatePaymentMethodCommand> {

    private final CheckoutRepository checkoutRepository;
    private final PaymentMethodRepository paymentMethodRepository;

    @Override
    public CheckoutUpdatePaymentMethodResponse handle(CheckoutUpdatePaymentMethodCommand checkoutUpdatePaymentMethodCommand) {
        Checkout checkout = checkoutRepository.findById(checkoutUpdatePaymentMethodCommand.getId()).orElseThrow();
        PaymentMethod paymentMethod = paymentMethodRepository.findById(checkoutUpdatePaymentMethodCommand.getPaymentMethod()).orElseThrow();
        checkout.setPaymentMethod(paymentMethod);
        checkoutRepository.save(checkout);
        log.info("PaymentMethod {} updated", checkoutUpdatePaymentMethodCommand.getId());
        return CheckoutUpdatePaymentMethodResponse.builder()
                .checkout(checkout.toDTO())
                .build();
    }
}
