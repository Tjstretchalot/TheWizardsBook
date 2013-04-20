/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;
import org.jbox2d.common.Vec2;

/**
 *
 * @author adam
 */
public class Level3 extends GameLevel {
    
    private World world;
    private Player player;
    
    public Level3(Game g) {
        super(g);
        world = game.getWorld();
        player = game.getPlayer();
    }
    
    public void initLevel() {
        
        game.getPlayer().setPaper(0);
        game.getPlayer().setGoblet(0);
        
        Wall wallLeft = new Wall(game);
        wallLeft.setPosition(new Vec2(-1485, 0));
            
        Wall wallRight = new Wall(game);
        wallRight.setPosition(new Vec2(1485, 0));
        
        Floor ground = new Floor(game);
        ground.setPosition(new Vec2(0, -370));
        
        player.putOn(ground);
        player.move(new Vec2(-50, 0));
        
        Body finish = new Body(world, new PolygonShape(-77f,46f, 73f,46f, 73f,36f, 53f,-04f, -57f,-04f, -77f,36f, -77f,46f), Body.Type.STATIC);
        finish.setPosition(new Vec2(0,  -160));
        finish.setImage(new BodyImage("images/platformextended.png"));
        
        Door door = new Door(game);
        door.putOn(finish);
        
        Platform pagePlatform = new Platform(game);
        pagePlatform.setPosition(new Vec2(-600, -160));
        
        Page page = new Page(game);
        page.putOn(pagePlatform);
        
        Platform gobletPlatform = new Platform(game);
        gobletPlatform.setPosition(new Vec2(600, -160));
 
        Goblet goblet = new Goblet(game);
        goblet.putOn(gobletPlatform);
        
    }
    
}
