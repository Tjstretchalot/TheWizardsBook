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
public class Level1 extends GameLevel {
    
    public World world;
    public Player player;
    private Body platform8; 
    private Floor ground;
    private Floor groundRight;
    private Floor groundLeft;
    
    public Level1(Game g){
        super(g);
        world = game.getWorld();
        player = game.getPlayer();
    }
    
    @Override
    public void initLevel() {
        
        // make the ground
        ground = new Floor(game);
        ground.setPosition(new Vec2(0, -370));        
        groundRight = new Floor(game);
        groundRight.setPosition(new Vec2(1360, -370));        
        groundLeft = new Floor(game);
        groundLeft.setPosition(new Vec2(-1360, -370));        
        
        Wall wallLeft = new Wall(game);
        wallLeft.setPosition(new Vec2(-1585, 0));
            
        Wall wallRight = new Wall(game);
        wallRight.setPosition(new Vec2(1585, 0));
        
        player.putOn(ground);
        player.move(new Vec2(-50, 0));
        
        
        
        Body finish = new Body(world, new PolygonShape(-77f,46f, 73f,46f, 73f,36f, 53f,-04f, -57f,-04f, -77f,36f, -77f,46f), Body.Type.STATIC);
        finish.setPosition(new Vec2(0, 400));
        finish.setImage(new BodyImage("images/platformextended.png"));
        
        Door door = new Door(game);
        door.putOn(finish);
        
        Body gobletPlatform = new Body(world, new PolygonShape(-77f,46f, 73f,46f, 73f,36f, 53f,-04f, -57f,-04f, -77f,36f, -77f,46f), Body.Type.STATIC);
        gobletPlatform.setPosition(new Vec2(-1000, 250));
        gobletPlatform.setImage(new BodyImage("images/platformextended.png"));
        
        Goblet goblet = new Goblet(game);
        goblet.putOn(gobletPlatform);
        
        Platform pagePlatform = new Platform(game);
        pagePlatform.setPosition(new Vec2(1300, 250));
        
        Page page = new Page(game);
        page.putOn(pagePlatform);
        
        Platform platform1 = new Platform(game);
        platform1.setPosition(new Vec2(300, -160));
        
        Platform platform2 = new Platform(game);
        platform2.setPosition(new Vec2(600, 0));
        
        Platform platform3 = new Platform(game);
        platform3.setPosition(new Vec2(1000, 100));
        
        Platform platform4 = new Platform(game);
        platform4.setPosition(new Vec2(-780, 0));
        
        Platform platform5 = new Platform(game);
        platform5.setPosition(new Vec2(800, 400));
        
        Platform platform6 = new Platform(game);
        platform6.setPosition(new Vec2(200, 250));
        
        Platform platform7 = new Platform(game);
        platform7.setPosition(new Vec2(-1200, -160));
        
        platform8 = new Body(game.getWorld(), PolygonShape.makeBox(100, 30), Body.Type.STATIC);
        platform8.setPosition(new Vec2(-1500, 70));
        platform8.setImage(new BodyImage("images/platform2.png"));
        
        Platform platform9 = new Platform(game);
        platform9.setPosition(new Vec2(-500, 450));
    
    }    
}
