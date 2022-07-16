package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.patterns.command;

public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}
