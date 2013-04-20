/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;

/**
 *
 * @author adam
 */
public class Platform extends Body implements CollisionListener {

    private Game game;
    
    public Platform(Game g) {
        super(g.getWorld(), new PolygonShape(-41f,43f, -41f,03f, -31f,-07f, 29f,-07f, 39f,33f, 39f,43f), Body.Type.STATIC);
        this.setImage(new BodyImage("images/platform.png"));
        g.getWorld().addCollisionListener(this);
        game = g;
    }
    
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getPlayer()) {
            game.getPlayer().resetDJ();
        }
    }    
}
