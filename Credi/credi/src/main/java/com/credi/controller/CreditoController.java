package com.credi.controller;

import com.credi.model.Credito;
import com.credi.service.CreditoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;

    public CreditoController(CreditoService creditoService) {
        this.creditoService = creditoService;
    }

    @GetMapping("/{numeroNfse}")
    public List<Credito> listarPorNumeroNfse(@PathVariable String numeroNfse) {
        return creditoService.listarPorNumeroNfse(numeroNfse);
    }

    @GetMapping("/credito/{numeroCredito}")
    public ResponseEntity<Credito> buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        Optional<Credito> credito = creditoService.buscarPorNumeroCredito(numeroCredito);

        if (credito.isPresent()) {
            return ResponseEntity.ok(credito.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/teste/{num}")
    public ResponseEntity<List<Object[]>> testarHibernateInterceptor(@PathVariable String num) {
        List<Object[]> resultado = creditoService.testarInterceptor(num);
        return ResponseEntity.ok(resultado);
    }

}