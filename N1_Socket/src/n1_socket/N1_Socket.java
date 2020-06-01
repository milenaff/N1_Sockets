/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n1_socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author italo
 */
public class N1_Socket {

    
//    private static ServerSocket server;
//    private static int port = 9876;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        //instancia Gerenciador
        GerenciadorFilaRequisicoes.getInstancia();
        GerenciadorFilaRequisicoes.getInstancia().Intancia_Servidor();        
        ThreadImpressora thread = new ThreadImpressora();
        thread.start();
        ServerSocket server = GerenciadorFilaRequisicoes.getInstancia().getServe();
        
        
        while (true) {

            System.out.println("Waiting for the client request");
            try (Socket socket = server.accept()) {

//                //pegar a requisição                                         
//                try (InputStream stream = socket.getInputStream()) {
//                    boolean ativo = true;
//                    while (ativo) {
//                        if (stream.available() != 0) {
//                            byte[] dados = new byte[stream.available()];
//                            stream.read(dados);
//                            String dadosLidos = new String(dados);
//                            Pega_Requisicao(dadosLidos);
//
////                            //Instancia a Thread
////                            ativo = false;
//
//                        }
//                        Thread.sleep(10);
//                    }
//                    System.out.println("Bye bye");//                    
//                }
                ThreadRequisicao thread_requisicao = new ThreadRequisicao();
                thread_requisicao.start();

            }
        }
     
      
    }
    
    public static void Pega_Requisicao(String mensagem) {

//        int impressora = GerenciadorFilaRequisicoes.getInstancia().Verifica_Impressora_Vazia();
//
//        switch (impressora) {
//
//            case 1: {
//                GerenciadorFilaRequisicoes.getInstancia().Adiciona_Requisicao_1(mensagem);
//                break;
//            }
//            case 2: {
//                GerenciadorFilaRequisicoes.getInstancia().Adiciona_Requisicao_2(mensagem);
//                break;
//            }
//            case 3: {
//                GerenciadorFilaRequisicoes.getInstancia().Adiciona_Requisicao_3(mensagem);
//                break;
//            }
//            case 4: {
//                GerenciadorFilaRequisicoes.getInstancia().Adiciona_Requisicao_4(mensagem);
//                break;
//            }
//
//        }
        GerenciadorFilaRequisicoes.getInstancia().Adiciona_Requisicao_1(mensagem);

    }
    
    

}

