/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Adam
 */
public class Door extends Body implements CollisionListener {
    
    /** The game */
    private Game game;

    public Door(Game g) {
        super(g.getWorld(), PolygonShape.makeBox(41, 78), Body.Type.STATIC);
        setImage(new BodyImage("images/door.png"));
        g.getWorld().addCollisionListener(this);
        game = g;
    }
    
    /**
     * Handles collision with the player
     * @param e Collision events involving this body
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody().equals(game.getPlayer())){
            if (game.getPlayer().getGoblet() == 1) {
                try {
                    game.changeLevel();
                } catch (IOException ex) {
                    Logger.getLogger(Door.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(game.getFrame(), "You need to put the paper in the goblet to unlock the door!");            
            }
        }
    }
}