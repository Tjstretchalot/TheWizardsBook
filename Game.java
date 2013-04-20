package game;

import city.soi.platform.*;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.ObjectOutputStream;
import org.jbox2d.common.Vec2;

/**
 * A very basic platform game.
 */
public class Game {

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
    // the window frame
    private final JFrame frame = new JFrame("The Wizard's Book");
    private StatePanel statepanel;
    private String name;
    private Sound sound;
    private Bat bat;
    
    /** Initialise a new Game. */
    public Game() {
            isOver = false;

            // make the world
            world = new World();
            
            // make a player
            player = new Player(this);
            player.setGravityStrength(5);
            
            bat = new Bat(this);
            bat.setPosition(new Vec2(-1000, 500));

            sound = new Sound("sound/main.wav");
            sound.loopSound();
            
            name =(String)JOptionPane.showInputDialog(frame, "Enter your name: ", "Enter Name", JOptionPane.PLAIN_MESSAGE);
            
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
            frame.addKeyListener(new KeyHandler(this));
            // quit the application when the game window is closed
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // display the world in the window
            frame.add(view);
            // don't let the game window be resized
            frame.setResizable(false);
            // size the game window to fit the world view
            frame.pack();
            // make the window visible
            frame.setVisible(true);
            
            statepanel = new StatePanel(this);
            frame.add(statepanel, BorderLayout.SOUTH);
                
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
            JOptionPane.showMessageDialog(frame, "Your score has been saved.");
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
    
    public JFrame getFrame() {
        return frame;
    }
    
    public Bat getBat() {
        return bat;
    }
    
    /** Play a game. */
    public static void main(String[] args) {
        new Game();
    }
}