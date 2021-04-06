/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketgameServer;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import model.GuessGame;

/**
 *
 * @author placideh
 */
public class ListThread extends Thread{
    Socket s;
    InputStream in;
    OutputStream out;
    public ListThread(Socket s) {
        this.s=s;
    }

    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try {
          
                in = s.getInputStream();
                out = s.getOutputStream();
                ObjectOutputStream obout = new ObjectOutputStream(out);
                ObjectInputStream obin = new ObjectInputStream(in);

                System.out.println((GuessGame) obin.readObject());
                ArrayList<GuessGame> glist = new ArrayList<>();
                glist.add((GuessGame) obin.readObject());
                ArrayList<GuessGame> list = showWinner(glist);
                obout.writeObject(list);
                obout.flush();
            

            
            s.close();
        } catch (Exception e) {

        }
    }
    public ArrayList showWinner(ArrayList<GuessGame> list) {
//        GuessGame temp=new GuessGame();
//        GuessGame temp2=new GuessGame();
//        GuessGame temp3=new GuessGame();
////       GuessGame[] geussArr=(GuessGame[]) list.toArray();
//      for(int i=0;i<list.size();i++){
//          for(int j=0;j<list.size()-1;j++){
//              if(list.get(j).getMarks()+list.get(j).getTimeTaken()>list.get(j+1).getMarks()+list.get(j+1).getTimeTaken()){
//                Arrays.sort(list.toArray());
//                temp=list.get(j);
//                temp2=list.get(j+1);
//                temp3=temp;
//                temp=temp2;
//                temp2=temp3;
//                  
//              }
//          }
//      }
        ArrayList<GuessGame> glist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            long markPercent = (list.get(i).getMarks() * 100) / 50;
            list.get(i).setMarks(markPercent);
            glist.add(list.get(i));

        }
        return list;
    }

    
}
