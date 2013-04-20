package game;

import city.soi.platform.*;
import java.util.ArrayList;
import org.jbox2d.common.Vec2;

/**
 * Basic players in a game.
 */
public class Player extends Actor {

    /**
     * The game.
     */
    private Game game;
    private Level1 level1;
    private int paper = 0;
    private int dj = 0;
    private int goblet = 0;
    private int score = 0;
    private int lives = 0;
    private ArrayList<PlayerStateListener> listeners;
    private int direction;    
    private ProjectileWeapon gun;

    /**
     * Initialise a new player.
     *
     * @param game The game in which the player will be playing.
     */
    
    public Player(Game game) {
        super(game.getWorld(), new PolygonShape(-59f,-24f, -39f,-64f, 51f,-64f, 51f,46f, -19f,76f, -59f,-24f));
        this.game = game;
        setImage(new BodyImage("images/wizardblue.png"));
        listeners = new ArrayList();
        ProjectileWeapon hg = new Handgun(game);
        hg.setPosition(new Vec2(this.getPosition().x, this.getPosition().y));
    }
    
    public void addPlayerStateListener(PlayerStateListener psl) {
        listeners.add(psl);
    }
    
    public void update() {
        for (PlayerStateListener psl : listeners) {
            psl.stateChanged(this);
        }
    }
    
    public void setPaper(int pap) {
        paper = pap;
    }
    
    public int getPaper() {
        return paper;
    }
    
    public int getDJ() {
        return dj;
    }
    
    public void addDJ() {
        dj++;
    }
    
    public void resetDJ() {
        dj = 0;
    }
    
    public void setGoblet(int gob) {
        goblet = gob;
    }
    
    public int getGoblet() {
        return goblet;
    }
    
    public void addScore(int sco) {
        score = sco + score;
        update();
    }
    
    public int getScore() {
        return score;
    }
    
    public void addLives(int l) {
        lives = l + lives;
    }
    
    public void takeLives(int l) {
        lives = lives - l;
    }
    
    public int getLives() {
        return lives;
    }
    
    public boolean hasGun(){
        return gun != null;
    }
    
    public ProjectileWeapon getGun(){
        return gun;
    }
    
    public void setGun(ProjectileWeapon pw){
        gun = pw;
    }
    
    public void setDirection(int dir) {
        direction = dir;
        System.out.println(direction);
    }
    
    public int getDirection() {
        return direction;
    }
    
}
