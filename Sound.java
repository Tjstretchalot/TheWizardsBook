/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.soi.platform.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author adam
 */
public class Sound{

    private SoundClip sound;
    
    public Sound(String path) {
        try{
           sound = new SoundClip(path); 
        }catch(UnsupportedAudioFileException uafe){
            uafe.printStackTrace();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }catch(LineUnavailableException lue){
            lue.printStackTrace();
        }
    }
    
    public void playSound(){
        sound.play();
    }
    
    public void loopSound() {
        sound.loop();
    }
    
    public void stopSound() {
        sound.stop();
    }
}
