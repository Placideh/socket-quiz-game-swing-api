/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + (int) (this.marks ^ (this.marks >>> 32));
        hash = 29 * hash + (int) (this.timeTaken ^ (this.timeTaken >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GuessGame other = (GuessGame) obj;
        if (this.marks != other.marks) {
            return false;
        }
        if (this.timeTaken != other.timeTaken) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

   
}
