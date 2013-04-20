/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jbox2d.common.Vec2;

/**
 *
 * @author adam
 */
public class Spikes extends Body implements CollisionListener {
    
    private Game game;
    
    public Spikes(Game g) {
        super(g.getWorld(), PolygonShape.makeBox(688, 35), Body.Type.STATIC);
        this.setImage(new BodyImage("images/spikeslong.png"));
        g.getWorld().addCollisionListener(this);
        game = g;
    }
    
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == game.getPlayer()) {
            game.getPlayer().destroy();
            if (game.getPlayer().getLives() < 1) {
                try {
                    game.gameOver();
                } catch (IOException ex) {
                    Logger.getLogger(Spikes.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                game.getPlayer().takeLives(1);
            }
        }
    }
}
