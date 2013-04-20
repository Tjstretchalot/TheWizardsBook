/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.*;

/**
 *
 * @author adam
 */
public class StatePanel extends JPanel implements PlayerStateListener {
    
    private JLabel score;
    private Game game;
    private ImageIcon icon = new ImageIcon("images/page_JLabel.png");
    
    public StatePanel(Game g) {
        score = new JLabel("Score: 0");
        this.add(score);
        game = g;
        g.getPlayer().addPlayerStateListener(this);
    }

    @Override
    public void stateChanged(Player p) {
        score.setText("Score: " + p.getScore());
        score.setIcon(icon); 
        score.setIconTextGap(10);
        this.add(score);
    }
}
