package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.saga.model;

public interface SagaStep<T> {

    String getName();

    SagaStepHandler<T> getHandler();

    SagaStepCompensator<T> getCompensator();
}
