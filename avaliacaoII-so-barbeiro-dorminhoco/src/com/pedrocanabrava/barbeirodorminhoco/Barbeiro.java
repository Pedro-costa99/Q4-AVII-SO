package com.pedrocanabrava.barbeirodorminhoco;


import java.util.logging.Level;
import java.util.logging.Logger;


public class Barbeiro extends Thread{
    static final int POLTRONAS = 5;
    static Semaforo cliente = new Semaforo(0);
    static Semaforo barbeiro = new Semaforo(0);
    static Semaforo semaforo = new Semaforo(1);
    static int aguardando = 0;
    static boolean atendendo = false;
    static boolean dormindo = false;

    
    public void atenderCliente(){
        System.out.println("O Barbeiro está atendendo um cliente");
        atendendo = true;
        try {
            Thread.sleep(sleepTime());
            System.out.println("O Barbeiro já terminou o atendimento");
            atendendo = false;
            Thread.sleep(300);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbeiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void barbeiro(){
        if(aguardando <= 0){
            System.out.println("Parece que o Barbeiro está dormindo");
            dormindo = true;
            cliente.D();
        } 
            semaforo.D();
            aguardando--;
            barbeiro.U();
            semaforo.U();
            dormindo = false;
            atenderCliente();
        
    }
    
   
    public static int sleepTime(){
        return (int) Math.floor(Math.random() * 3000);
    }
    
    @Override
    public void run(){
        while(true){
            barbeiro();
        }
    }
    
}