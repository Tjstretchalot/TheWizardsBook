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
public class Floor extends Body implements CollisionListener {
    
    private Game game;
    float y = this.getPosition().y;
    
    public Floor(Game g) {
        super(g.getWorld(), PolygonShape.makeBox(680, 66), Body.Type.STATIC);
        this.setImage(new BodyImage("images/floororiginal.png"));
        g.getWorld().addCollisionListener(this);
        game = g;
    }
    
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getPlayer()) {
            game.getPlayer().resetDJ();
            game.getPlayer().setDeadStop(true);
        }
    }
    
    public float getY() {
        return y;
    }
    
}
