/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.*;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import org.jbox2d.common.Vec2;
/**
 *
 * @author adam
 */
public class BgView extends WorldView implements StepListener {
    
    private Game game;
    
    public BgView (Game g, int w, int h) {
        super(g.getWorld(), w, h);
        g.getWorld().addStepListener(this);
        game = g;
    }    

    @Override
    public void paintBackground(Graphics2D g) {
        g.drawImage(new ImageIcon("images/black.png").getImage(), 0, 0, this);
    }
    
    @Override
    public void preStep(StepEvent e) {

    }    

    @Override
    public void postStep(StepEvent e) {
        
        float x = game.getPlayer().getPosition().x;
        float y = game.getPlayer().getPosition().y;
        
        if (game.getPlayer().getPosition().y <= -50) {
            if (game.getPlayer().getPosition().x > -900 && game.getPlayer().getPosition().x < 900) {
                setCamera(new Vec2(x, -50), 1f);
            } else if (game.getPlayer().getPosition().x < -500) {
                setCamera(new Vec2(-900, -50), 1f);
            } else if (game.getPlayer().getPosition().x > 500) {
                setCamera(new Vec2(900, -50), 1f);
            }
        } else if (game.getPlayer().getPosition().x > -900 && game.getPlayer().getPosition().x < 900) {
                setCamera(new Vec2(x, y), 1f);
        } else if (game.getPlayer().getPosition().x < -500) {
            setCamera(new Vec2(-900, y), 1f);
        } else if (game.getPlayer().getPosition().x > 500) {
            setCamera(new Vec2(900, y), 1f);
        }
    }
}
