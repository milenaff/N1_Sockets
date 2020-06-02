/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n1_socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @author italo
 */
public class GerenciadorFilaRequisicoes {

    private static Object objeto = new Object();
    public static GerenciadorFilaRequisicoes _instance;
    
    private static ServerSocket server;
    private static int port = 9879;

    public static GerenciadorFilaRequisicoes getInstancia() {
        if (_instance == null) {
            _instance = new GerenciadorFilaRequisicoes();
        }
        return _instance;
    }
    //fila de mensagens
    public static ConcurrentLinkedQueue<String> FilaRequisicoes1 = new ConcurrentLinkedQueue<String>();    

    public void Adiciona_Requisicao_1(String mensagem) {
        FilaRequisicoes1.add(mensagem);
    }

    public void Retira_Requisicao_1() {
        if (!FilaRequisicoes1.isEmpty()) {
            FilaRequisicoes1.remove();
        }
    }    

    
    public ServerSocket getServe() {
        return server;

    }
    
    public void Intancia_Servidor() throws IOException{
        if(server == null)
            server = new ServerSocket(port);
    }


}
