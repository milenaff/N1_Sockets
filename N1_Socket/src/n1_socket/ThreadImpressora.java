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

    }
    
    public String Retorna_Impressora(int numero_impressora) {

        switch (numero_impressora) {

            case 1: {
                return "Impressora 1";
            }
            case 2: {
                return "Impressora 2";
            }
            case 3: {
                return "Impressora 3";
            }
            case 4: {
                return "Impressora 4";
            }

        }
        return "";

    }
    
}
