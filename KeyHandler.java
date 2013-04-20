/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.DebugSettings;
import city.soi.platform.DebugViewer;
import java.awt.event.KeyAdapter;

/**
 *
 * Key handler for player management
 */
public class KeyHandler extends KeyAdapter {

    /**
     * The game
     */
    private Game game;
    /**
     * The player
     */
    private Player player;
    /**
     * The debug view
     */
    private DebugViewer debugViewer;
    /**
     * Constructs a key handler to manage the player
     *
     * @param g A copy of the game
     */
    public KeyHandler(Game g) {
        game = g;
        player = game.getPlayer();
    }

    /**
     * Handle key press events for walking and jumping.
     */
    public void keyPressed(java.awt.event.KeyEvent e) {
        if (game.isOver()) {
            return;
        }
        int code = e.getKeyCode();
        
        // W = jump        
        if (code == java.awt.event.KeyEvent.VK_SPACE) {
            if (player.getDJ() < 2) {
                player.jump(500);
                player.addDJ();
            } else {
                if (!player.isJumping()) {
                    player.resetDJ();
                }
            }
            
            if (!player.isJumping()) {
                player.jump(450);
                player.addDJ();
            }
            
            // A = walk left
        } else if (code == java.awt.event.KeyEvent.VK_A) {
                player.walkLeft(350);
                player.setDirection(180);
            // D = walk right
        } else if (code == java.awt.event.KeyEvent.VK_D) {
                player.walkRight(350);
                player.setDirection(0);
            // F1 key toggles display of debug view
        } else if (code == java.awt.event.KeyEvent.VK_F1) {
            if (debugViewer == null) {
                debugViewer = new DebugViewer(new DebugSettings(game.getWorld()));
            }
            if (debugViewer.isRunning()) {
                debugViewer.stopViewer();
            } else {
                debugViewer.startViewer();
            }
        } else if (code == java.awt.event.KeyEvent.VK_F) {
            if (player.hasGun()){
                player.getGun().shoot();
            }
        }
    }

    /**
     * Handle key release events (stop walking).
     */
    public void keyReleased(java.awt.event.KeyEvent e) {
        if (game.isOver()) {
            return;
        }
        int code = e.getKeyCode();
        if (code == java.awt.event.KeyEvent.VK_A) {
            player.stopWalking();
        } else if (code == java.awt.event.KeyEvent.VK_D) {
            player.stopWalking();
        }
    }
}
