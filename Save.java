/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.Serializable;

/**
 *
 * @author adam
 */
public class Save implements Serializable {
    
    private int score;
    private String name;
    
    public Save(int score, String name) {
        this.score = score;
        this.name = name;
    }
    
    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score = score;
    } 
    
    public String getName() {
        return name;
    }
}
