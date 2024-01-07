package org.sobs.sobs.sounds;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.sobs.sobs.constants.Constants;

import java.io.File;

public class Sounds extends Thread{
    private String path;
    private MediaPlayer player;
    public Sounds(String path) {
        this.path = path;
    }
    public void run() {
        playMusic();
    }
    private void playMusic() {
        if (!this.path.isEmpty()) {
            String temp = this.path;
            try {
                temp = Constants.CURRENT_FILE_PATH + temp;
                player = new MediaPlayer(new Media(new File(temp).toURI().toString()));
                player.play();
                if (path.endsWith("StartScreenSound.mp3")) {
                    player.setCycleCount(5);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void stopMusic() {
        this.player.stop();
    }
}
