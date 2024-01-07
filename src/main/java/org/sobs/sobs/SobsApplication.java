package org.sobs.sobs;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.sobs.sobs.constants.Constants;
import org.sobs.sobs.controllers.LogoController;
import org.sobs.sobs.images.Others;

public class SobsApplication extends Application {
    @Override
    public void start(Stage stage) {
        LogoController logo = new LogoController();
        stage.setAlwaysOnTop(true);
        stage.getIcons().add(Constants.getImage(Others.LOGO.getPath()));
        Pane pane = new Pane();
        ImageView logoImage = new ImageView(Constants.getImage(Others.LOGO.getPath()));
        pane.getChildren().add(logoImage);
        Scene scene = new Scene(pane);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.show();
        logo.launch(scene);
    }

    public static void main(String[] args) {
        launch();
    }
}