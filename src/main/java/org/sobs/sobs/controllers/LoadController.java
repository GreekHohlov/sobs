package org.sobs.sobs.controllers;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.sobs.sobs.constants.Constants;
import org.sobs.sobs.images.BackGround;
import org.sobs.sobs.images.Button;

public class LoadController {
    private static double loading = 0.0;
    Stage stage = new Stage();
    Pane pane = new Pane();
    Scene startScene;
    Scene scene;
    ProgressBar progressBar = new ProgressBar();
    private static ImageView buttonNext;
    private AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            progressBar.setProgress(getLoading());
        }
    };
    public void launch(Scene scene) {
        startScene = scene;
        stage.setX(0);
        stage.setY(0);
        setPane();
        setButton();
        scene = new Scene(pane, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        scene.getStylesheets().add((getClass().getResource("/org/sobs/sobs/css/style.css")).toExternalForm());
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();
        timer.start();
    }
    private void setPane() {
        ImageView backGround = new ImageView(Constants.getImage(BackGround.START_BACKGROUND.getPath()));
        backGround.setFitWidth(Constants.SCREEN_WIDTH);
        backGround.setFitHeight(Constants.SCREEN_HEIGHT);
        progressBar.getStyleClass().add("progressbar");
        progressBar.setPrefWidth(200);
        progressBar.setPrefHeight(30);
        progressBar.setLayoutX(Constants.SCREEN_WIDTH / 2 - progressBar.getPrefWidth() / 2);
        progressBar.setLayoutY(850);
        buttonNext = new ImageView(Constants.getImage(Button.NEXT.getPath()));
        buttonNext.setLayoutX(Constants.SCREEN_WIDTH / 2 - Constants.getImage(Button.NEXT.getPath()).getWidth() / 2);
        buttonNext.setLayoutY(progressBar.getLayoutY() + Constants.getImage(Button.NEXT.getPath()).getHeight() * 2);
        buttonNext.setVisible(false);
        pane.getChildren().add(backGround);
        pane.getChildren().add(progressBar);
        pane.getChildren().add(buttonNext);
        pane.setPrefWidth(Constants.SCREEN_WIDTH);
        pane.setPrefHeight(Constants.SCREEN_HEIGHT);
    }
    private void setButton() {
        buttonNext.setOnMouseEntered(e -> buttonNext.setImage(Constants.getImage(Button.START_ENTERED.getPath())));
        buttonNext.setOnMouseExited(e -> buttonNext.setImage(Constants.getImage(Button.START.getPath())));
        buttonNext.setOnMouseClicked(e -> LevelController.stageShow());
    }
    public static double getLoading() {
        return loading;
    }
    public static void setLoading(double loadingAdd) {
        loading += loadingAdd;
        if ((1 - loading) < 0.0001) {
            buttonNext.setVisible(true);
        }
    }
}
