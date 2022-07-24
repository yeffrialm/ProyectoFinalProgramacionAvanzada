package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model;

public interface SagaStepCompensator<T> {

    void handle(SagaPayload<T> sagaPayload);
}
