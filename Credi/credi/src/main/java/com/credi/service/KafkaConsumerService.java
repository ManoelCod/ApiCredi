package com.credi.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "solicitacao_credito", groupId = "grupo-solicitacao-credito")
    public void processarSolicitacaoCredito(ConsumerRecord<String, String> record) {
        System.out.println("Processando crédito: " + record.value());
    }
}