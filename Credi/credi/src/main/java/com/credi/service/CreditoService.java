package com.credi.service;

import com.credi.config.HibernateInterceptor;
import com.credi.model.Credito;
import com.credi.repository.CreditoRepository;
import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditoService {

    @Autowired
    private HibernateInterceptor hibernateInterceptor;
    @Autowired
    private EntityManager entityManager;

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

    public List<Object[]> testarInterceptor(String numeroCredito) {
        String sql = "SELECT * FROM credito WHERE numero_credito = :numeroCredito";
        hibernateInterceptor.inspect(sql); // Intercepta a consulta

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("numeroCredito", numeroCredito);

        List<Object[]> resultado = query.getResultList();
        System.out.println("Resultado da consulta: " + resultado); // Debug no console

        return resultado; // Retorna os dados para o Controller
    }

}