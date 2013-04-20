/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.Body;
import city.soi.platform.BodyImage;
import city.soi.platform.PolygonShape;
import city.soi.platform.StepEvent;
import city.soi.platform.StepListener;
import org.jbox2d.common.Vec2;

/**
 *
 * @author adam
 */
public class Bat extends Body implements StepListener {
    
    private Game game;
    private int health;
    
    public Bat(Game g)
    {
        super(g.getWorld(), new PolygonShape(18.5f,-24.0f, 38.5f,30.0f, 37.5f,31.0f, 8.5f,23.0f, -29.5f,1.0f, -34.5f,-25.0f, -33.5f,-26.0f, 18.5f,-24.0f), Body.Type.DYNAMIC);
        setImage(new BodyImage("images/bat.png"));
        game = g;
        g.getWorld().addStepListener(this);
        health = 5;
    }
    
    public void setHealth(int health) {
        if (health < 1) {
            this.destroy();
        } else {
            this.health = this.health + health;
        }
        System.out.println(health);
    }
    
    @Override
    public void preStep(StepEvent e) {
        float speed = 0.1f;
        // player - enemy
        Vec2 direction = game.getPlayer().getPosition().sub(this.getPosition());
        float distance = direction.length();

        if(distance > 80)
        {
            this.setPosition(new Vec2(this.getPosition().x += direction.x * speed, this.getPosition().y += direction.y * speed));
        }
    }

    @Override
    public void postStep(StepEvent e) {
       
    }
}
