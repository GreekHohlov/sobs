package org.sobs.sobs.controllers;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.sobs.sobs.constants.Constants;
import org.sobs.sobs.images.BackGround;

public class LevelController {
    private static Stage stage = new Stage();
    private Pane pane = new Pane();
    Scene startScene;
    private Scene scene;
    public void launch(Scene scene) {
        startScene = scene;
        stage.setX(0);
        LoadController.setLoading(0.1);
        stage.setY(0);
        LoadController.setLoading(0.1);
        setPane();
        LoadController.setLoading(0.3);
        scene = new Scene(pane, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        LoadController.setLoading(0.1);
        stage.setScene(scene);
        LoadController.setLoading(0.1);
        stage.setAlwaysOnTop(true);
        LoadController.setLoading(0.1);
        stage.initStyle(StageStyle.TRANSPARENT);
        LoadController.setLoading(0.1);
        stage.setResizable(false);
        LoadController.setLoading(0.1);
    }
    private void setPane() {
        ImageView backGround = new ImageView(Constants.getImage(BackGround.START_BACKGROUND.getPath()));
        backGround.setFitWidth(Constants.SCREEN_WIDTH);
        backGround.setFitHeight(Constants.SCREEN_HEIGHT);
        pane.getChildren().add(backGround);
        pane.setPrefWidth(Constants.SCREEN_WIDTH);
        pane.setPrefHeight(Constants.SCREEN_HEIGHT);
    }
    public static void stageShow() {
        stage.show();
    }
}
