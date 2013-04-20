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
public class Level2 extends GameLevel {
    
    private World world;
    private Player player;
    
    public Level2(Game g) {
        super(g);
        world = game.getWorld();
        player = game.getPlayer();
    }
    
    @Override
    public void initLevel() {
        game.getPlayer().setPaper(0);
        game.getPlayer().setGoblet(0);
        
        Floor ground = new Floor(game);
        ground.setPosition(new Vec2(0, -370));
        
        Wall wallLeft = new Wall(game);
        wallLeft.setPosition(new Vec2(-1685, 0));
            
        Wall wallRight = new Wall(game);
        wallRight.setPosition(new Vec2(1685, 0));
        
        player.putOn(ground);
        player.move(new Vec2(-50, 0));
        
        Spikes spikeLeft = new Spikes(game);
        spikeLeft.setPosition(new Vec2(-1375, -400));
        
        Spikes spikeRight = new Spikes(game);
        spikeRight.setPosition(new Vec2(1375, -400));
        
        Body finish = new Body(world, new PolygonShape(-77f,46f, 73f,46f, 73f,36f, 53f,-04f, -57f,-04f, -77f,36f, -77f,46f), Body.Type.STATIC);
        finish.setPosition(new Vec2(-1500, 400));
        finish.setImage(new BodyImage("images/platformextended.png"));
        
        Door door = new Door(game);
        door.putOn(finish);
        
        Body gobletPlatform = new Body(world, PolygonShape.makeBox(100, 30), Body.Type.STATIC);
        gobletPlatform.setPosition(new Vec2(1350, -300));
        gobletPlatform.setImage(new BodyImage("images/platform2.png"));
        
        Goblet goblet = new Goblet(game);
        goblet.putOn(gobletPlatform);
        
        Platform platform1 = new Platform(game);
        platform1.setPosition(new Vec2(0, 0));
        
        Platform platform2 = new Platform(game);
        platform2.setPosition(new Vec2(200, -160));
        
        Platform platform3 = new Platform(game);
        platform3.setPosition(new Vec2(-250, -160));
        
        Platform platform4 = new Platform(game);
        platform4.setPosition(new Vec2(-550, 100));
        
        Platform platform5 = new Platform(game);
        platform5.setPosition(new Vec2(0, 200));
        
        Platform platform6 = new Platform(game);
        platform6.setPosition(new Vec2(100, 200));
        
        Platform pagePlatform = new Platform(game);
        pagePlatform.setPosition(new Vec2(200, 200));
        
        Page page = new Page(game);
        page.putOn(pagePlatform);
        
        Platform platform7 = new Platform(game);
        platform7.setPosition(new Vec2(600, 400));
        
        Platform platform8 = new Platform(game);
        platform8.setPosition(new Vec2(600, 0));

        Platform platform10 = new Platform(game);
        platform10.setPosition(new Vec2(-1000, 300));
    }
    
}
