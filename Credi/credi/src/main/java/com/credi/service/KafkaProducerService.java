package com.credi.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaProducerService {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducerService.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarSolicitacaoCredito(String mensagem) {
        try {
            kafkaTemplate.send("solicitacao_credito", mensagem);
            logger.info("Mensagem enviada para o tópico solicitacao_credito: {}", mensagem);
        } catch (Exception e) {
            logger.error("Erro ao enviar mensagem para o Kafka", e);
        }
    }
}