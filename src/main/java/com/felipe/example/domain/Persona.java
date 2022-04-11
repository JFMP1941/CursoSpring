package com.felipe.example.domain;

import lombok.Data;

/**
 *
 * @author Felipe
 */
//notacion para no tener que agregar los getter and setter de cada uno de los atributos
// de la clase persona
@Data
public class Persona {

    private String nombre, apellido, email, telefono;

}
