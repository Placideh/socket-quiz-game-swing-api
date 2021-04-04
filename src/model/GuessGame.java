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
    private long marks;
    private long timeTaken;

    public GuessGame(long marks, long timeTaken) {
        this.marks = marks;
        this.timeTaken = timeTaken;
    }

    public GuessGame() {
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
        return "GuessGame{" + "marks=" + marks + ", timeTaken=" + timeTaken + '}';
    }
    
}
