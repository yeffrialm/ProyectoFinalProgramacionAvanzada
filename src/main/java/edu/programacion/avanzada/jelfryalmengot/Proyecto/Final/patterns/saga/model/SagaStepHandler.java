package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model;

public interface SagaStepHandler<T> {

    void handle(SagaPayload<T> sagaPayload);
}
