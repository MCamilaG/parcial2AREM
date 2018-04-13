/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.net.MalformedURLException;
import java.io.*; 
import java.net.*; 
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author camila
 */
public class Cliente extends Thread{
    
     public final static int THREADS = 20;
     
     public static void main(String[] args){
        for(int i=0;i<20;i++){
            Thread thread = new Cliente();
            thread.start();
        }    
    }
     
    @Override
    public void run(){
        try{
            System.out.println("'/hello'");
            result("hello"); 
            System.out.println("'/'");
            result("");           
            System.out.println("'/db'");
            result("db");                        
        } catch(MalformedURLException e){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
            
        }
    
    }
    
    public void result(String path) throws MalformedURLException{
        URL result = new URL("https://parcial2arem.herokuapp.com/"+path);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(result.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);
        }            
    }
    
}
