/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.Body;
import city.soi.platform.PolygonShape;

/**
 *
 * @author adam
 */
public class Wall extends Body {
    
    private Game game;
    
    public Wall(Game g) {
        super(g.getWorld(), PolygonShape.makeBox(1, 1000), Body.Type.STATIC);
        game = g;
    }
}
