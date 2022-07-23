package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.saga.model;

public interface SagaStepCompensator<T> {

    void handle(SagaPayload<T> sagaPayload);
}
