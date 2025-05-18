package com.credi.factory;

public class MensagemFactory {
    public static String criarLogAuditoria(String servico, String metodo, String mensagem) {
        return String.format("Serviço: %s | Método: %s | Mensagem: %s", servico, metodo, mensagem);
    }
    // Adicione outros tipos de mensagem conforme necessário
}