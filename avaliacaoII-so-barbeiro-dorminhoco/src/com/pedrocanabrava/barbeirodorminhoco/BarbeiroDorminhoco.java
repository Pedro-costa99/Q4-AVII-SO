package com.pedrocanabrava.barbeirodorminhoco;

public class BarbeiroDorminhoco {

    public static void main(String[] args) {
        Barbeiro barbeiro = new Barbeiro();
        Thread thread01 = new Thread(barbeiro);
        
        Cliente cliente = new Cliente();
        Thread thread02 = new Thread(cliente);
        
        thread01.start();
        thread02.start();
    }
    
}
