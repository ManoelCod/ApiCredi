// package com.credi.service;

// import org.apache.kafka.clients.consumer.ConsumerRecord;
// import org.junit.jupiter.api.Test;

// class KafkaConsumerServiceTest {

// @Test
// void testProcessarSolicitacaoCredito() {
// KafkaConsumerService consumer = new KafkaConsumerService();
// ConsumerRecord<String, String> record = new
// ConsumerRecord<>("solicitacao_credito", 0, 0L, null,
// "testeCredito");
// consumer.processarSolicitacaoCredito(record);
// }

// @Test
// void testProcessarLogAuditoria() {
// KafkaConsumerService consumer = new KafkaConsumerService();
// ConsumerRecord<String, String> record = new ConsumerRecord<>("log_auditoria",
// 0, 0L, null, "testeAuditoria");
// consumer.processarLogAuditoria(record);
// }
// }
