package com.pedrocanabrava.barbeirodorminhoco;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente extends Thread{
    
    public void clientes(){
        Barbeiro.semaforo.D();
        
        if(Barbeiro.aguardando < Barbeiro.POLTRONAS){
            Barbeiro.aguardando++; 
            Barbeiro.cliente.U();
            Barbeiro.semaforo.U();
        } 
            Barbeiro.semaforo.U();
            System.out.println("Alguém não pôde esperar e saiu da fila");
        
    }
    
    @Override
    public void run(){
        while(true){
            clientes();
            System.out.println("Opa! Entrou um novo cliente!");
            try {
                Thread.sleep(Barbeiro.sleepTime());
            } catch (InterruptedException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}