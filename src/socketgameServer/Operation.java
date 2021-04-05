/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketgameServer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import model.GuessGame;

/**
 *
 * @author placideh
 */
public class Operation extends Thread {
    Socket s;
    OutputStream out;
    InputStream in;
    DataOutputStream dout;
    DataInputStream din;
    PrintWriter pout;
    BufferedReader bin;
    Operation(Socket s){
        this.s=s;
        
    }

    public Operation() {
    }
    
    @Override
    public void run() {
        super.run(); //To change body of generated methods, choose Tools | Templates.
        try{
                while(true){
                    in = s.getInputStream();
//                    din=new DataInputStream(in);
                    bin = new BufferedReader(new InputStreamReader(in));
//                    int quest = Integer.parseInt(bin.readLine());
//                    int answer=din.read();
                    out = s.getOutputStream();
                    
                    pout = new PrintWriter(out,true);
//                    if (quest > 0) {
//                        pout.println(questions(quest));
//                        pout.flush();
////                        break;
//                    }
                     if(bin.readLine().contains("users")){
                        String question,answer;
                        question=bin.readLine();
                        answer=bin.readLine();
                        int que=Integer.parseInt(question);
                        int ans=Integer.parseInt(answer);
                        pout.println("users");
                        pout.println(questions(que));
                        pout.println(answers(que,ans));
                        pout.flush();
                        
                    }else{
                        break;
                    } 
                   
//                    dout=new DataOutputStream(out);
//                    dout.writeUTF(questions(quest));
//                    dout.flush();
                    
                }
            
            s.close();
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    public String questions(int question){
        String q="";
        switch(question){
            case 1:{
                 q="12*3+10=?";
                break;
            }
            case 2:{
                q="4*4=?";
                break;
            }
            case 3:{
                q="1+5*5=?";
                break;
            }
            case 4:{
                q="11*5=?";
                break;
            }
            case 5:{
                q="15/3=?";
                break;
            }
            default:
            {
                q="you have reached to the end of question JUST SUBMIT";
                break;
            }
            
        }
        return q;
    }
    public int answers(int question,int  answer){
        int result = 0;
        int q=0;
        switch (question) {
            case 1: {
                q = 12*3+10;
                if (q == answer) {
                    result += 10;
                    
                }else{
                    result+=0;
                }
                break;
            }
            case 2: {
                q = 4*4;
                if (q == answer) {
                    result += 10;
                }else {
                    result += 0;
                }
                break;
            }
            case 3: {
                q =1+5*5;
                if (q == answer) {
                    result += 10;
                }else {
                    result += 0;
                }
                break;
            }
            case 4: {
                q = 11*5;
                if (q == answer) {
                    result += 10;
                }else {
                    result += 0;
                }
                break;
            }
            case 5: {
                q = 15/3;
                if (q == answer) {
                    result += 10;
                }else {
                    result += 0;
                }
                break;
            }
            default: {
                break;
            }

        }
        return result;
        
    }
//    public ArrayList showWinner(ArrayList<GuessGame> list){
//        GuessGame temp=new GuessGame();
//       GuessGame[] geussArr=(GuessGame[]) list.toArray();
//       for(int i=0;i<geussArr.length;i++){
//            for(int j=0;j<geussArr.length;j++){
//                if(geussArr[j].getMarks()+geussArr[j].getTimeTaken()>geussArr[j+1].getMarks()+geussArr[j+1].getTimeTaken()){
//                    temp=geussArr[j];
//                    geussArr[j]=geussArr[j+1];
//                    geussArr[j+1]=temp;
//                }
//            }
//        }
//       ArrayList<GuessGame> glist=new ArrayList<>();
//       for(int i=0;i<geussArr.length;i++){
//           long markPercent=(geussArr[i].getMarks()*100)/50;
//           geussArr[i].setMarks(markPercent);
//           glist.add(geussArr[i]);
//           
//       }
//        return glist;
//    }
    public ArrayList showWinner(ArrayList<GuessGame> list){
        GuessGame temp=new GuessGame();
        GuessGame temp2=new GuessGame();
        GuessGame temp3=new GuessGame();
//       GuessGame[] geussArr=(GuessGame[]) list.toArray();
      for(int i=0;i<list.size();i++){
          for(int j=0;j<list.size()-1;j++){
              if(list.get(j).getMarks()+list.get(j).getTimeTaken()>list.get(j+1).getMarks()+list.get(j+1).getTimeTaken()){
                Arrays.sort(list.toArray());
                temp=list.get(j);
                temp2=list.get(j+1);
                temp3=temp;
                temp=temp2;
                temp2=temp3;
                  
              }
          }
      }
       ArrayList<GuessGame> glist=new ArrayList<>();
       for(int i=0;i<list.size();i++){
           long markPercent=(list.get(i).getMarks()*100)/50;
           list.get(i).setMarks(markPercent);
           glist.add(list.get(i));
           
       }
        return list;
    }
    
    
}
