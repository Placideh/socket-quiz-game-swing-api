/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketgameServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import model.GuessGame;

/**
 *
 * @author placideh
 */
public class Server  {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception  {
        
        ServerSocket  ss=new ServerSocket(21172);
        while(true){
            Socket s=ss.accept();
            Operation ops=new Operation(s);
            System.out.println("Server Started...");
            ops.start();
            
        }
       
    }
    public ArrayList<GuessGame> list() {
         
        return new ArrayList<GuessGame>();
    }
   
}
