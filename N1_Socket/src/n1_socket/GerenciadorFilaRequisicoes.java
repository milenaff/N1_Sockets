/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n1_socket;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author italo
 */
public class GerenciadorFilaRequisicoes {

    private static Object objeto = new Object();
    public static GerenciadorFilaRequisicoes _instance;

    public static GerenciadorFilaRequisicoes getInstancia() {
        if (_instance == null) {
            _instance = new GerenciadorFilaRequisicoes();
        }
        return _instance;
    }
    //fila de mensagens
    public static ConcurrentLinkedQueue<String> FilaRequisicoes1 = new ConcurrentLinkedQueue<String>();
    public static ConcurrentLinkedQueue<String> FilaRequisicoes2 = new ConcurrentLinkedQueue<String>();
    public static ConcurrentLinkedQueue<String> FilaRequisicoes3 = new ConcurrentLinkedQueue<String>();
    public static ConcurrentLinkedQueue<String> FilaRequisicoes4 = new ConcurrentLinkedQueue<String>();

    public void Adiciona_Requisicao_1(String mensagem) {
        FilaRequisicoes1.add(mensagem);
    }

    public void Retira_Requisicao_1() {
        if (!FilaRequisicoes1.isEmpty()) {
            FilaRequisicoes1.remove();
        }
    }

    public void Adiciona_Requisicao_2(String mensagem) {
        FilaRequisicoes2.add(mensagem);
    }

    public void Retira_Requisicao_2() {
        if (!FilaRequisicoes2.isEmpty()) {
            FilaRequisicoes2.remove();
        }
    }

    public void Adiciona_Requisicao_3(String mensagem) {
        FilaRequisicoes3.add(mensagem);
    }

    public void Retira_Requisicao_3() {
        if (!FilaRequisicoes3.isEmpty()) {
            FilaRequisicoes3.remove();
        }
    }

    public void Adiciona_Requisicao_4(String mensagem) {
        FilaRequisicoes4.add(mensagem);
    }

    public void Retira_Requisicao_4() {
        if (!FilaRequisicoes4.isEmpty()) {
            FilaRequisicoes4.remove();
        }
    }

}
