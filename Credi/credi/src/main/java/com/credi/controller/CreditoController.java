package com.credi.controller;

import com.credi.model.Credito;
import com.credi.service.CreditoService;
import com.credi.service.KafkaProducerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/creditos")
public class CreditoController {

    private final CreditoService creditoService;
    private final KafkaProducerService kafkaProducerService;

    public CreditoController(CreditoService creditoService, KafkaProducerService kafkaProducerService) {
        this.creditoService = creditoService;
        this.kafkaProducerService = kafkaProducerService;

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

    @PostMapping("/solicitar")
    public String solicitarCredito(@RequestParam String clienteId, @RequestParam double valor) {
        String evento = "Cliente: " + clienteId + ", Valor: " + valor;
        kafkaProducerService.enviarSolicitacaoCredito(evento);
        return "Solicitação de crédito enviada!";
    }

}