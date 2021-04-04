/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketgameServer;

import java.util.Date;

/**
 *
 * @author placideh
 */
public class TestGame {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println();
        int marks=20;
        long time=date.getHours()+date.getMinutes()+date.getSeconds();
        System.out.println(time);
        long timeres=(time)/100;
        int marksres=(marks*100)/50;
        long result=(marksres+timeres)/2;
        System.out.println(result);
        System.out.println(date);
        
    }
   
}
