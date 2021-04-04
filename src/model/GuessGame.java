/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author placideh
 */
public class GuessGame {
    private String name;
    private long marks;
    private long timeTaken;

    public GuessGame(String name, long marks, long timeTaken) {
        this.name = name;
        this.marks = marks;
        this.timeTaken = timeTaken;
    }

   

    public GuessGame() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public long getMarks() {
        return marks;
    }

    public void setMarks(long marks) {
        this.marks = marks;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    @Override
    public String toString() {
        return "GuessGame{" + "name=" + name + ", marks=" + marks + ", timeTaken=" + timeTaken + '}';
    }

   
}
