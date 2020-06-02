
package n1_socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class N1_Socket {


    public static void main(String[] args) throws IOException, InterruptedException {
    
        //instancia Gerenciador
        GerenciadorFilaRequisicoes.getInstancia();
        GerenciadorFilaRequisicoes.getInstancia().Intancia_Servidor();        
        ThreadImpressora thread = new ThreadImpressora();
        thread.start(); 
        ServerSocket server = GerenciadorFilaRequisicoes.getInstancia().getServe();        
        System.out.println("Waiting for the client request");
        
        
        while (true) {

            ThreadRequisicao thread_requisicao = new ThreadRequisicao();
            thread_requisicao.start();
            Thread.sleep(10);
        }
             
        
                     
        
       
                
    }    
    public static void Pega_Requisicao(String mensagem) {

        GerenciadorFilaRequisicoes.getInstancia().Adiciona_Requisicao_1(mensagem);

    }
    
    

}

