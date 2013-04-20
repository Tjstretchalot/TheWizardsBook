package game;

import city.soi.platform.*;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JPanel;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.ObjectOutputStream;
import org.jbox2d.common.Vec2;

/**
 * A very basic platform game.
 */
public class Game extends JPanel {

    /** The player (a specialised Actor). */
    private Player player;
    /** Game over flag. */
    private boolean isOver;
    /** The World in which the game bodies move and interact.*/
    private World world;
    /** A graphical display of the world (a specialised JPanel). */
    private BgView view;
    /** A debug display. */
    private DebugViewer debugViewer;
    // arraylist for holding gamelevels
    public ArrayList<GameLevel> gameLevels;
    // count the levels
    private int levelCounter;
    // holds the current level value
    private GameLevel currentLevel;
    private StatePanel statepanel;
    private String name;
    private Sound sound;
    private Bat bat;
    
    /** Initialise a new Game. */
    public Game() {
            isOver = false;
            // make a player
            player = new Player(this);
            player.setGravityStrength(5);
            
            bat = new Bat(this);
            bat.setPosition(new Vec2(-1000, 500));

            sound = new Sound("sound/main.wav");
            sound.loopSound();
            
            name =(String)JOptionPane.showInputDialog(null, "Enter your name: ", "Enter Name", JOptionPane.PLAIN_MESSAGE); // won't work in applets, use something else
            
            //LevelCount
            levelCounter = 0;
            
            //ArrayList stuff
            gameLevels = new ArrayList();
            
            Level1 level1 = new Level1(this);
            Level2 level2 = new Level2(this);
            Level3 level3 = new Level3(this);
            gameLevels.add(level1);
            gameLevels.add(level2);
            gameLevels.add(level3);
            
            //First Level Initialisation
            currentLevel = gameLevels.get(levelCounter);
            currentLevel.initLevel();
            
            // make a view
            view = new BgView(this, 1366, 768);
            //view.setDrawStats(true); // uncomment this line to show simulation stats in game display

            // add some keyboard handling
            addKeyListener(new KeyHandler(this));
            // display the world in the window
            add(view);
            // make the window visible
            
            statepanel = new StatePanel(this);
            add(statepanel, BorderLayout.SOUTH);
                
            // start!
            world.start();
    }
    
    public void changeLevel() throws IOException {
            levelCounter++;
        if (levelCounter > 2) {
                gameOver();
                return;
        }
        for (Body b : world.getBodies()) {
            if (b != player) {
                world.destroyBody(b);
            }
        }
        currentLevel = gameLevels.get(levelCounter);
        currentLevel.initLevel();
    }
    
    /** Is the game over? */
    public boolean isOver() {
        return isOver;
    }

    /** End the game. */
    public void gameOver() throws IOException {
            Save score = new Save(player.getScore(), name);
            if (name == null) {
                FileOutputStream fos = new FileOutputStream("player.save");
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(score);
            } else {
                FileOutputStream fos = new FileOutputStream(name + ".save");
                ObjectOutputStream out = new ObjectOutputStream(fos);
                out.writeObject(score);
            }       
            JOptionPane.showMessageDialog(null, "Your score has been saved."); // Won't work in applets, use something else
            world.pause();
            isOver = true;
            System.exit(0);
    }

    /** The world in which this game is played. */
    public World getWorld() {
        return world;
    }

    /** The world view. */
    public BgView getView() {
        return view;
    }

    /** The player. */
    public Player getPlayer() {
        return player;
    }
    
    public String getName() {
    	return name;
    }
    
    public Bat getBat() {
        return bat;
    }
}