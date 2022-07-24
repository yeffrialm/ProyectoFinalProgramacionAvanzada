package edu.programacion.avanzada.jelfryalmengot.Proyecto.Final.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class APIError {

    private int status;
    private String message;
}
