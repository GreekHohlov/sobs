package org.sobs.sobs.controllers;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.sobs.sobs.constants.Constants;
import org.sobs.sobs.images.BackGround;

public class SelectPlayerController {
    private final Stage STAGE = new Stage();
    private final Pane PANE = new Pane();
    private final Scene SCENE = new Scene(PANE, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    private Scene prevoiusScene;
    public void launch(Scene scene) {
        prevoiusScene = scene;
        STAGE.setX(0);
        STAGE.setY(0);
        setPane();
        setButton();
        STAGE.setScene(SCENE);
        STAGE.setAlwaysOnTop(true);
        STAGE.initStyle(StageStyle.TRANSPARENT);
        STAGE.setResizable(false);
        STAGE.show();
    }
    private void setPane() {
        ImageView backGround = new ImageView(Constants.getImage(BackGround.START_BACKGROUND.getPath()));
        backGround.setFitWidth(Constants.SCREEN_WIDTH);
        backGround.setFitHeight(Constants.SCREEN_HEIGHT);
        PANE.getChildren().add(backGround);
        PANE.setPrefWidth(Constants.SCREEN_WIDTH);
        PANE.setPrefHeight(Constants.SCREEN_HEIGHT);
    }
    private void setButton() {
    }
}
