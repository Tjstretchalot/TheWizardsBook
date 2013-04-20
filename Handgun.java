/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.PolygonShape;

/**
 *
 * @author charlie
 */
public class Handgun extends ProjectileWeapon{
    
    public Handgun(Game g){
        super(g);
        addShape(PolygonShape.makeBox(10, 5));
    }
    
    public void shoot(){
        if (game.getPlayer().getDirection() == 0) {
            BulletRight b = new BulletRight(game);
        } else if (game.getPlayer().getDirection() == 180) {
            BulletLeft b = new BulletLeft(game);
        }
    }
}
