package com.example.prueba.dto;

import lombok.Data;

@Data
public class UserDTO {
    //TODO: tenemos el objecto quemado con la configuracion cargada en el properties
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private Long telefono;
    private String direccion;
    private String ciudad;
}
