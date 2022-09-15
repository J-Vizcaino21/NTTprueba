package com.example.prueba.service;

import com.example.prueba.dto.SearchDTO;
import com.example.prueba.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    //TODO: tenemos el objecto quemado con la configuracion cargada en el properties
    @Value( "${spring.user.name1}" )
    private String primerNombre;
    @Value( "${spring.user.name2}" )
    private String segundoNombre;
    @Value( "${spring.user.lastname1}" )
    private String primerApellido;
    @Value( "${spring.user.lastname2}" )
    private String segundoApellido;
    @Value( "${spring.user.phone}" )
    private Long telefono;
    @Value( "${spring.user.address}" )
    private String direccion;
    @Value( "${spring.user.city}" )
    private String ciudad;
    public UserDTO getUsr(SearchDTO dto) {
        //TODO: Aqui Deberia existir un repositorio con comunicacion a nuestra base de datos y extrar informacion
        UserDTO user = new UserDTO();
        //TODO: comprobamos que las sentencias de reglas de la prueba se cumplan para regresar un usuario quemado
        if(dto.getType().equalsIgnoreCase("C") && dto.getDocument() == 23445322){
            user.setCiudad(ciudad);
            user.setDireccion(direccion);
            user.setTelefono(telefono);
            user.setPrimerNombre(primerNombre);
            user.setSegundoNombre(segundoNombre);
            user.setPrimerApellido(primerApellido);
            user.setSegundoApellido(segundoApellido);
            logger.info("usuario encontrado en nuestra base de datos");
            return user;
        }else{
            //TODO: decimos a traves de log que no existe este documento de user en nuestro db
            logger.error("Este usuario no se encuentra en nuestra base de datos");
            return null;
        }
    }
}
