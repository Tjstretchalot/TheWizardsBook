/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;
/**
 *
 * @author Adam
 */
public class Goblet extends Body implements CollisionListener {
    
    /** The game */
    private Game game;

    public Goblet(Game g)
    {
        super(g.getWorld(), new PolygonShape(-23f,-55f, 17f,-55f, 17f,35f, -03f,65f, -23f,35f, -23f,-55f), Body.Type.STATIC);
        setImage(new BodyImage("images/firegoblet1.png"));
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
            if (game.getPlayer().getPaper() == 1) {
            	game.getPlayer().setGoblet(1);
            	this.destroy();
            	Goblet_Shapeless gobletShapeless = new Goblet_Shapeless(game);
            	gobletShapeless.setPosition(this.getPosition());
            	JOptionPane.showMessageDialog(game.getFrame(), "You have put the page into the goblet and can now progress to the next level.");
                game.getPlayer().update();
            } else {
            	JOptionPane.showMessageDialog(game.getFrame(), "You need to put that page in here to progress.");
            }
        }
    }
}