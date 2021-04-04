/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketgameServer;

import java.net.Socket;

/**
 *
 * @author placideh
 */
public class Operation extends Thread {
    Socket s;
    Operation(Socket s){
        this.s=s;
        
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try{
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    
}
