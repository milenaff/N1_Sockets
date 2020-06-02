
package n1_socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import static n1_socket.N1_Socket.Pega_Requisicao;

public class ThreadRequisicao extends Thread {
    
     ServerSocket server = GerenciadorFilaRequisicoes.getInstancia().getServe();
    
      @Override
    public void run() {

        try (Socket socket = server.accept()) {

            try (InputStream stream = socket.getInputStream()) {
                boolean ativo = true;
                while (ativo) {
                    if (stream.available() != 0) {
                        byte[] dados = new byte[stream.available()];
                        stream.read(dados);
                        String dadosLidos = new String(dados);
                        Pega_Requisicao(dadosLidos);
                        //ativo = false;
                    }
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(ThreadRequisicao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}


