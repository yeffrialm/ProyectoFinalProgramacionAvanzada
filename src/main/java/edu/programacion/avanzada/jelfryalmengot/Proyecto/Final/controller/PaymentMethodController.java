package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.controller;


import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment.CreatePaymentMethodRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment.DeletePaymentMethodRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.CreatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.DeletePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.GetPaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.services.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jelfry on 7/09/2022.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<GetPaymentMethodResponse> get() {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(paymentMethodService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentMethodResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(List.of(paymentMethodService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreatePaymentMethodResponse> create(@RequestBody CreatePaymentMethodRequest createPaymentMethodRequest) {
        return ResponseEntity.ok(CreatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.create(createPaymentMethodRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMethodResponse> update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return ResponseEntity.ok(UpdatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.update(updatePaymentMethodRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeletePaymentMethodResponse> delete(@RequestBody DeletePaymentMethodRequest deletePaymentMethodRequest) {
        paymentMethodService.delete(deletePaymentMethodRequest);
        return ResponseEntity.ok(DeletePaymentMethodResponse.builder().build());
    }
}
