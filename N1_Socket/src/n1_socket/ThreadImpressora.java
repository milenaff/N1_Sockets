
package n1_socket;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadImpressora extends Thread {
    
    @Override
    public void run() {        

        boolean status_impressora_1 = true;
        boolean status_impressora_2 = true;
        boolean status_impressora_3 = true;
        boolean status_impressora_4 = true;
        boolean fila;

        while (true) {
            fila = GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.isEmpty();
            if (!fila && status_impressora_1) {
                try {
                    status_impressora_1 = false;
                    Thread.sleep(2000);
                    System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.poll() + " Impressora 1");
                    status_impressora_1 = true;
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadImpressora.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            fila = GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.isEmpty();

            if (!fila && status_impressora_2) {
                try {
                    status_impressora_2 = false;
                    Thread.sleep(2000);
                    System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.poll() + " Impressora 2");
                    status_impressora_2 = true;
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadImpressora.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            fila = GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.isEmpty();

            if (!fila && status_impressora_3) {
                try {
                    status_impressora_3 = false;
                    Thread.sleep(2000);
                    System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.poll() + " Impressora 3");
                    status_impressora_3 = true;
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadImpressora.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            fila = GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.isEmpty();

            if (!fila && status_impressora_4) {
                try {
                    status_impressora_4 = false;
                    Thread.sleep(2000);
                    System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.poll() + " Impressora 4");
                    status_impressora_4 = true;
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadImpressora.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }
    
  
    
}
