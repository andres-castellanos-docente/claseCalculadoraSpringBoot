package com.iteram.controlador;

import com.iteram.servicios.IServicioCalculadora;
import io.corp.calculator.TracerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Gestiona el método GET /api/calcula
 */
@RestController
@RequestMapping("/api")
public class ControladorCalculadora {

    @Lazy
    @Autowired
    private IServicioCalculadora servicioCalculadora;

    private TracerImpl tracer = new TracerImpl();


    @GetMapping(value = "/calcula")
    public ResponseEntity<Double> calcula(@RequestParam(name = "primero") BigDecimal primerNumero,
                                          @RequestParam(name = "segundo") BigDecimal segundoNumero,
                                          @RequestParam(name = "operacion") String operacion) {

        double result = this.servicioCalculadora.calcula(primerNumero, segundoNumero, operacion);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/sumar")
    public ResponseEntity<Double> sumar(@RequestParam(name = "primero") BigDecimal primerNumero,
                                          @RequestParam(name = "segundo") BigDecimal segundoNumero) {

        double result = this.servicioCalculadora.calcula(primerNumero, segundoNumero, "suma");
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @GetMapping(value = "/restar")
    public ResponseEntity<Double> restar(@RequestParam(name = "primero") BigDecimal primerNumero,
                                        @RequestParam(name = "segundo") BigDecimal segundoNumero) {

        double result = this.servicioCalculadora.calcula(primerNumero, segundoNumero, "resta");
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/multi")
    public ResponseEntity<Double> multi(@RequestParam(name = "primero") BigDecimal primerNumero,
                                           @RequestParam(name = "segundo") BigDecimal segundoNumero) {

        double result = this.servicioCalculadora.calcula(primerNumero, segundoNumero, "multiplicacion");
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/division")
    public ResponseEntity<Double> division(@RequestParam(name = "primero") BigDecimal primerNumero,
                                         @RequestParam(name = "segundo") BigDecimal segundoNumero) {

        double result = this.servicioCalculadora.calcula(primerNumero, segundoNumero, "division");
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/calculapath/{primero}/{segundo}/{operacion}")
    public ResponseEntity<Double> calculapath(@PathVariable(value = "primero") BigDecimal primerNumero,
                                              @PathVariable(value = "segundo") BigDecimal segundoNumero,
                                              @PathVariable(value = "operacion") String operacion) {
        double result = this.servicioCalculadora.calcula(primerNumero, segundoNumero, operacion);
        tracer.trace(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}