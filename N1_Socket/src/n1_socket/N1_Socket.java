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

    
    private static ServerSocket server;
    private static int port = 9876;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
        
        
         server = new ServerSocket(port);
        while(true){
            System.out.println("Waiting for the client request");
            try (Socket socket = server.accept()) {
                
                //instancia Gerenciador
                GerenciadorFilaRequisicoes.getInstancia();
                
                
                //pegar a requisição                                         
                try (InputStream stream = socket.getInputStream()) {        
                    boolean ativo = true;
                    while (ativo)
                    {
                        if (stream.available() != 0)
                        {
                            byte[] dados = new byte[stream.available()];
                            stream.read(dados);
                            String dadosLidos = new String(dados);
                            int requisicao;
                            if(tryParseInt(dadosLidos)){
                                requisicao = Integer.parseInt(dadosLidos);
                                //Instancia a Thread
                                ativo = false;
                            }
                          
                        }
                        Thread.sleep(10);
                    }
                    System.out.println("Bye bye");
                }
                
                
                
                
            }
        }
    }
    
    private static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

