package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("il client è partito");
        Socket s = new Socket("localhost", 3000);
        System.out.println("il client si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        BufferedReader inTastiera = new BufferedReader(new InputStreamReader(System.in));
        String messaggio;
        int tentativi=0;
        
        do {
            tentativi=tentativi+1;
            System.out.print("Inserisci il tuo numero da 1 a 100 :");
            messaggio = inTastiera.readLine();


            out.writeBytes(messaggio + "\n");

            String stringaElaborata = in.readLine();
            
            System.out.println(stringaElaborata);
            if(stringaElaborata.equals("=")){
                
                
                System.out.println("vuoi continuare a giocare? y/n");
               
                stringaElaborata=inTastiera.readLine();
                
                out.writeBytes(stringaElaborata);
                if(stringaElaborata.equals("n")){
                  break;  
                }
            }
        

        } while (true);
        System.out.println("ci hai provato : "+ tentativi + " volte");
        s.close();
        
    }
    
}