/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;
/**
 *
 * @author Adam
 */
public class Goblet_Shapeless extends Body {
    
    /** The game */
    private Game game;

    public Goblet_Shapeless(Game g)
    {
        super(g.getWorld(), Body.Type.STATIC);
        setImage(new BodyImage("images/firegoblet1.png"));
        game = g;
    }
}