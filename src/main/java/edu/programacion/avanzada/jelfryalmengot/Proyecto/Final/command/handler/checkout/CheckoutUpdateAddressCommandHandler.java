package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.handler.checkout;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.command.checkout.CheckoutUpdateAddressCommand;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Address;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.domain.Checkout;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.checkout.CheckoutUpdateAddressResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandEvent;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command.CommandHandler;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.AddressRepository;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author jelfry on 7/09/2022.
 */
@Component
@RequiredArgsConstructor
@CommandEvent(command = CheckoutUpdateAddressCommand.class)
@Slf4j

public class CheckoutUpdateAddressCommandHandler implements CommandHandler<CheckoutUpdateAddressResponse, CheckoutUpdateAddressCommand> {


    private final CheckoutRepository checkoutRepository;
    private final AddressRepository addressRepository;

    @Override
    public CheckoutUpdateAddressResponse handle(CheckoutUpdateAddressCommand checkoutUpdateAddressCommand) {
        Checkout checkout = checkoutRepository.findById(checkoutUpdateAddressCommand.getId()).orElseThrow();
        Address address = addressRepository.findById(checkoutUpdateAddressCommand.getAddress()).orElseThrow();
        checkout.setAddress(address);
        checkoutRepository.save(checkout);
        log.info("Address {} updated", CheckoutUpdateAddressCommand.getId());
        return CheckoutUpdateAddressResponse.builder()
                .checkout(checkout.toDTO())
                .build();

    }
}