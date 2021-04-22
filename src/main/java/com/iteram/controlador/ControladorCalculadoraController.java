package com.iteram.controlador;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api")
public class ControladorCalculadoraController {
    @GetMapping(value = "/holamundo")
    public String holamundo() {

        return "hola mundo";
    }

}
