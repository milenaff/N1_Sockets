/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package n1_socket;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author italo
 */
public class ThreadImpressora extends Thread {
    
    @Override
    public void run() {
        ///fazer alguma coisa
        while (true) {
            if (!GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.isEmpty()) {
                System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes1.poll() + " Impressora 1");
            }
            if (!GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes2.isEmpty()) {
                System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes2.poll() + " Impressora 2");
            }
            if (!GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes3.isEmpty()) {
                System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes3.poll() + " Impressora 3");
            }
            if (!GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes4.isEmpty()) {
                System.out.println(GerenciadorFilaRequisicoes.getInstancia().FilaRequisicoes4.poll() + " Impressora 4");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadImpressora.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    
  
    
}
