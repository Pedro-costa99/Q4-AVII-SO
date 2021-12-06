package com.pedrocanabrava.barbeirodorminhoco;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Semaforo {
    private int accountant = 0;
    
    public Semaforo(int initialValue){
        accountant = initialValue;
    }
    
    public synchronized void D(){
        while(accountant <= 0){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Semaforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        accountant--;
    }
    
    public synchronized void U(){
        accountant++;
        
    }
    
}
