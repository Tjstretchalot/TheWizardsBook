/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;

/**
 *
 * @author charlie
 */
public abstract class ProjectileWeapon extends Body implements CollisionListener {
    
    protected int ammo;
    protected Game game;
    
    public ProjectileWeapon(Game g){
        super(g.getWorld());
        g.getWorld().addCollisionListener(this);
        game = g;
    }
    
    public abstract void shoot();
    
    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() == game.getPlayer()){
            game.getPlayer().setGun(this);
            this.destroy();
        }
    }

}
