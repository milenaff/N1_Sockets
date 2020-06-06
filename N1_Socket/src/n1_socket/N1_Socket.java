
package n1_socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class N1_Socket {


    public static void main(String[] args) throws IOException, InterruptedException {
    
        //instancia Gerenciador
        GerenciadorFilaRequisicoes.getInstancia();        
        ThreadImpressora thread = new ThreadImpressora();
        thread.start();         
        System.out.println("Waiting for the client request");
        ThreadRequisicao thread_requisicao = new ThreadRequisicao();
        thread_requisicao.start();    
        
        
        Scanner scan = new Scanner(System.in);
        try {
            boolean sair = false;
            do {
                System.out.println("Welcome");
                System.out.println("Choose one option:");
                System.out.println("1 - Show clients");
                System.out.println("2 - Get out");
                int opcao = scan.nextInt();
                switch (opcao) {
                    case 1:
                        thread_requisicao.listarClientes();
                        break;
                    case 2:
                        sair = true;
                        break;
                }
            } while (!sair);
        } finally {
            scan.close();
            thread_requisicao.encerra();       
        }
        
        
        
        
       
             
        
                     
        
       
                
    }    
    public static void Pega_Requisicao(String mensagem) {

        GerenciadorFilaRequisicoes.getInstancia().Adiciona_Requisicao_1(mensagem);

    }
    
    

}

