package org.sobs.sobs.controllers;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogoController {
    private static Scene currentScene;
    public void launch(Scene scene) {
        currentScene = scene;
        timer.start();
    }
    private int time = 50;
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if (time <= 0) {
                new StartController().launch();
                timer.stop();
                ((Stage) (currentScene.getWindow())).close();
            } else {
                time--;
            }
        }
    };
}