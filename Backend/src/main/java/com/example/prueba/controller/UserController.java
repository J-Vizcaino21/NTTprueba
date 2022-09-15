package com.example.prueba.controller;

import com.example.prueba.dto.SearchDTO;
import com.example.prueba.dto.UserDTO;
import com.example.prueba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {

    private final UserService service;

    //TODO: Inyectamos dependencia de servicio
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("user")
    @ResponseStatus(value= HttpStatus.OK)
    public UserDTO getClients(@RequestBody SearchDTO searchDTO) {
        //TODO: seteamos el objecto en nuestro dto para ser enviado al service a su verificacion de pasos
        return service.getUsr(searchDTO);
    }
}
