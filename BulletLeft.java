/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import city.soi.platform.*;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 *
 * @author charlie
 */
public class BulletLeft extends Body implements CollisionListener {
    private Game game;
    
    public BulletLeft(Game g){
        super(g.getWorld(), new CircleShape(3));
        
        setFillColor(Color.RED);
        setPosition(g.getPlayer().getPosition().add(new Vec2(-10, 0)));
        this.applyImpulse(new Vec2(-50, 0));
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getBat()) {
            game.getBat().setHealth(-1);
            this.destroy();
        }
    }
}
