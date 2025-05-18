package com.credi.service;

import com.credi.model.Credito;
import com.credi.repository.CreditoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

class CreditoServiceTest {

    @Test
    void testListarPorNumeroNfse() {
        CreditoRepository creditoRepository = mock(CreditoRepository.class);
        // KafkaProducerService kafkaProducerService = mock(KafkaProducerService.class);

        CreditoService service = new CreditoService(creditoRepository);

        String nfse = "7891011";
        List<Credito> expected = Collections.singletonList(new Credito());
        when(creditoRepository.findByNumeroNfse(nfse)).thenReturn(expected);

        List<Credito> result = service.listarPorNumeroNfse(nfse);

        // verify(kafkaProducerService, times(1))
        // .enviarLogAuditoria(eq("CreditoService"), eq("listarPorNumeroNfse"),
        // contains(nfse));
        verify(creditoRepository, times(1)).findByNumeroNfse(nfse);
        assert result.equals(expected);
    }

    @Test
    void testBuscarPorNumeroCredito() {
        CreditoRepository creditoRepository = mock(CreditoRepository.class);
        // KafkaProducerService kafkaProducerService = mock(KafkaProducerService.class);

        CreditoService service = new CreditoService(creditoRepository);

        String numeroCredito = "12345";
        Credito credito = new Credito();
        when(creditoRepository.findByNumeroCredito(numeroCredito)).thenReturn(credito);

        var result = service.buscarPorNumeroCredito(numeroCredito);

        // verify(kafkaProducerService, times(1))
        // .enviarLogAuditoria(eq("CreditoService"), eq("buscarPorNumeroCredito"),
        // contains(numeroCredito));
        verify(creditoRepository, times(1)).findByNumeroCredito(numeroCredito);
        assert result.isPresent() && result.get().equals(credito);
    }
}
