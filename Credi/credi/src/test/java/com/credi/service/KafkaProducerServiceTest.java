// package com.credi.service;

// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.kafka.core.KafkaTemplate;

// import static org.mockito.Mockito.*;

// class KafkaProducerServiceTest {

// @Test
// void testEnviarLogAuditoria() {
// KafkaTemplate<String, String> kafkaTemplate =
// Mockito.mock(KafkaTemplate.class);
// KafkaProducerService service = new KafkaProducerService(kafkaTemplate);

// service.enviarLogAuditoria("ServicoTeste", "metodoTeste", "mensagemTeste");

// verify(kafkaTemplate, times(1)).send(eq("log_auditoria"), contains("Servico:
// ServicoTeste"));
// }
// }