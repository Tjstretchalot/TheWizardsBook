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
public class Page extends Body implements CollisionListener {
    
    /** The game */
    private Game game;

    public Page(Game g)
    {
        super(g.getWorld(), new PolygonShape(00f,30f, 20f,00f, -10f,-20f, -30f,10f, 00f,30f), Body.Type.STATIC);
        setImage(new BodyImage("images/page.png"));
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
            game.getPlayer().setPaper(1);
            game.getPlayer().addScore(10);
            this.destroy();
        }
    }
}