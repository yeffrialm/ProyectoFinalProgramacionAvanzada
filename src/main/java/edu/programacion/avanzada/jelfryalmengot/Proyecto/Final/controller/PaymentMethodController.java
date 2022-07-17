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
        return ResponseEntity.ok(paymentMethodService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentMethodResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(paymentMethodService.get(id));
    }

    @PostMapping
    public ResponseEntity<CreatePaymentMethodResponse> create(@RequestBody CreatePaymentMethodRequest createPaymentMethodRequest) {
        return ResponseEntity.ok(paymentMethodService.create(createPaymentMethodRequest));
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMethodResponse> update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return ResponseEntity.ok(paymentMethodService.update(updatePaymentMethodRequest));
    }

    @DeleteMapping
    public ResponseEntity<DeletePaymentMethodResponse> delete(@RequestBody DeletePaymentMethodRequest deletePaymentMethodRequest) {
        return ResponseEntity.ok(paymentMethodService.delete(deletePaymentMethodRequest));
    }
}
