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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    ObjectOutputStream obout;
    ObjectInputStream obin ;
    int counter=0;
    private static int result;
    GuessGame gues;
    ArrayList<GuessGame> guesList=new ArrayList<>();
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
                    bin = new BufferedReader(new InputStreamReader(in));
                    out = s.getOutputStream();
                    pout = new PrintWriter(out,true);
                    
                     if(bin.readLine().contains("users")){
                        String question,answer;
//                        name=bin.readLine();
//                        date=bin.readLine();
                        answer=bin.readLine();
                        question=bin.readLine();
//                        long date2=Long.parseLong(date);
                        int ans=Integer.parseInt(answer);
                        int que=Integer.parseInt(question);
                        int res=que-1;
                        pout.println("users");
                        int answerReturned=answers(res,ans);
                        if(counter!=6&&res!=6){
                            pout.println(answerReturned);
                            pout.println(questions(que));
                            pout.flush();
                            counter++;
                        
                        }
                        
//                        gues=new GuessGame(name,result,date2);
//                        guesList.add(gues);
//                        pout.println(guesList);
                        ListThread list=new ListThread();
                        list.showWinner(guesList);
                        if(counter>=5&&res>=5){
                            result=0;
                            counter=0;
                        }
                        
                    } else{
                        break;
                    } 
                    
                }
                
               
            
            s.close();
//            pout.println(userReply(bin));
            
//            userReplyObject(obin);
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    public PrintWriter userReply(BufferedReader bin){
        try{
            
        
        while (true) {
            in = s.getInputStream();
            bin = new BufferedReader(new InputStreamReader(in));
            out = s.getOutputStream();
            pout = new PrintWriter(out, true);

            if (bin.readLine().contains("users")) {
                String question, answer;
                answer = bin.readLine();
                question = bin.readLine();
                int ans = Integer.parseInt(answer);
                int que = Integer.parseInt(question);
                int res = que - 1;
                pout.println("users");
                int answerReturned = answers(res, ans);
                pout.println(answerReturned);
                pout.println(questions(que));
                pout.flush();
                return pout;

            } else {
                break;
            }

        }

        s.close();
        }catch(Exception e){
            
        }
        return pout;
    }
    public ObjectOutputStream userReplyObject(ObjectInputStream obin){
        try{
            while(true){
                obout = new ObjectOutputStream(out);
                 obin = new ObjectInputStream(in);
                 GuessGame game=(GuessGame)obin.readObject();
                 System.out.println(game);
                 obout.writeObject(game);
                 return obout;
                 
            }
        }catch(Exception e){
            
        }
        return obout;
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
         
        int q=0;
        switch (question) {
            case 0:{
                result+=0;
                break;
            }
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
    public ArrayList showWinner(GuessGame game){
//        GuessGame temp=new GuessGame();
//        GuessGame temp2=new GuessGame();
//        GuessGame temp3=new GuessGame();
//        ArrayList<GuessGame> list=new ArrayList<>();
//        list.add(game);
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
       ArrayList<GuessGame> glist=new ArrayList<>();
//       ArrayList<GuessGame> list=new ArrayList<>();
       glist.add(game);
       for(int i=0;i<glist.size();i++){
           long markPercent=(glist.get(i).getMarks()*100)/50;
           glist.get(i).setMarks(markPercent);
           glist.add(glist.get(i));
           
       }
        return glist;
    }
    
    
}
