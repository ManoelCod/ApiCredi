package com.credi.service;

import com.credi.model.Credito;
import com.credi.repository.CreditoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    private final CreditoRepository creditoRepository;

    public CreditoService(CreditoRepository creditoRepository) {
        this.creditoRepository = creditoRepository;
    }

    public List<Credito> listarPorNumeroNfse(String numeroNfse) {
        return creditoRepository.findByNumeroNfse(numeroNfse);
    }

    public Optional<Credito> buscarPorNumeroCredito(String numeroCredito) {
        return Optional.ofNullable(creditoRepository.findByNumeroCredito(numeroCredito));
    }
}