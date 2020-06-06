
package n1_socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static n1_socket.N1_Socket.Pega_Requisicao;

public class ThreadRequisicao extends Thread {
    
    private boolean ServidorAtivo;
    private static ServerSocket server;
    private static int port = 9879;
     private List<Client> clientesConectados = Collections.synchronizedList(new ArrayList<Client>());

    @Override
    public void run() {

        try {
            ServidorAtivo = true;
            server = new ServerSocket(port);
            while (ServidorAtivo) {
                Socket socket = server.accept();
                adicionaClient(socket);
                Thread.sleep(10);
            }
        } catch (IOException | InterruptedException ex) {
            if (ex.getMessage().equals("socket closed")) {
                System.out.println("Conexão server encerrada...");
            } else {
                Logger.getLogger(ThreadRequisicao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }


    private void adicionaClient(Socket socket) {
        Client manager = new Client();
        manager.setClientSocket(socket);
        clientesConectados.add(manager);
        Thread threadSocket = new Thread(manager);
        threadSocket.start();
    }

    public void listarClientes() {
        for (Client cliente : clientesConectados) {
            cliente.identifiqueSe();
        }
    }
    
    public void encerra() throws IOException {
        clientesConectados.forEach((cliente) -> {
            try {
                cliente.encerra();
            } catch (IOException ex) {
                Logger.getLogger(ThreadRequisicao.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        ServidorAtivo = false;
        server.close();
    }



}


