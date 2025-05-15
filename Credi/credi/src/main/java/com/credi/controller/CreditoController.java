package com.credi.controller;

import com.credi.model.Credito;
import com.credi.service.CreditoService;
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
    public Optional<Credito> buscarPorNumeroCredito(@PathVariable String numeroCredito) {
        return creditoService.buscarPorNumeroCredito(numeroCredito);
    }
}