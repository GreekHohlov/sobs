package org.sobs.sobs.controllers;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.sobs.sobs.constants.Constants;
import org.sobs.sobs.images.BackGround;
import org.sobs.sobs.images.Button;
import org.sobs.sobs.images.Others;
import org.sobs.sobs.sounds.Sounds;
import org.sobs.sobs.sounds.SoundsName;

public class StartController {
//    private ObjectInputStream ois = Constants.getObjectInputStream(DataFiles.PLAYER.getFilePath());
    private final Stage STAGE = new Stage();
    private final Pane PANE = new Pane();
    private final Scene SCENE = new Scene(PANE, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
    private final Sounds START_MUSIC = new Sounds(SoundsName.START_SCREEN.getSoundName());
    private Sounds buttonEntered;
    private Sounds buttonExited;
    private Sounds buttonClick;
    private ImageView buttonExit;
    private ImageView buttonMenu;
    private ImageView buttonNewGame;
    private ImageView buttonSettings;
    private ImageView buttonLoad;
    private final AnimationTimer TIMER = new AnimationTimer() {
        @Override
        public void handle(long l) {
            new HistoryController().launch(SCENE);
            TIMER.stop();
            START_MUSIC.stopMusic();
        }
    };

    public void launch() {
        STAGE.setX(0);
        STAGE.setY(0);
        setPane();
        setButton();
        STAGE.setScene(SCENE);
        STAGE.getIcons().add(Constants.getImage(Others.LOGO.getPath()));
        STAGE.setAlwaysOnTop(true);
        STAGE.initStyle(StageStyle.TRANSPARENT);
        STAGE.setResizable(false);
        STAGE.show();
        START_MUSIC.start();
    }

    private void setPane() {
        ImageView backGround = new ImageView(Constants.getImage(BackGround.START_BACKGROUND.getPath()));
        backGround.setFitWidth(Constants.SCREEN_WIDTH);
        backGround.setFitHeight(Constants.SCREEN_HEIGHT);
        buttonNewGame = new ImageView(Constants.getImage(Button.NEW_GAME.getPath()));
        buttonNewGame.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X);
        buttonNewGame.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y * 4);
        buttonLoad = new ImageView(Constants.getImage(Button.LOAD.getPath()));
        buttonLoad.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X);
        buttonLoad.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y * 3);
        buttonSettings = new ImageView(Constants.getImage(Button.SETTINGS.getPath()));
        buttonSettings.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X);
        buttonSettings.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y * 2);
//        buttonMenu = new ImageView(Constants.getImage(Button.MENU.getPath()));
//        buttonMenu.setLayoutX(Constants.SCREEN_WIDTH / 2 - Constants.getImage(Button.MENU.getPath()).getWidth() / 2);
//        buttonMenu.setLayoutY(buttonNewGame.getLayoutY() + Constants.getImage(Button.MENU.getPath()).getHeight() * 2);
        buttonExit = new ImageView(Constants.getImage(Button.EXIT.getPath()));
        buttonExit.setLayoutX(Constants.START_SCREEN_BUTTON_POSITION_X);
        buttonExit.setLayoutY(Constants.SCREEN_HEIGHT - Constants.START_SCREEN_BUTTON_POSITION_Y);
        PANE.getChildren().add(backGround);
        PANE.getChildren().add(buttonNewGame);
        PANE.getChildren().add(buttonExit);
        PANE.getChildren().add(buttonLoad);
        PANE.getChildren().add(buttonSettings);
//        PANE.getChildren().add(buttonMenu);
    }

    private void setButton() {
        buttonNewGame.setOnMouseEntered(e -> {
            buttonNewGame.setImage(Constants.getImage(Button.NEW_GAME_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonNewGame.setOnMouseExited(e -> {
            buttonNewGame.setImage(Constants.getImage(Button.NEW_GAME.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonNewGame.setOnMouseClicked(e -> {
            buttonNewGame.setImage(Constants.getImage(Button.NEW_GAME_CLICK.getPath()));
            buttonClick = new Sounds(SoundsName.BUTTON_CLICK.getSoundName());
            buttonClick.start();
            new NewGame().start();
        });
        buttonLoad.setOnMouseEntered(e -> {
            buttonLoad.setImage(Constants.getImage(Button.LOAD_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonLoad.setOnMouseExited(e -> {
            buttonLoad.setImage(Constants.getImage(Button.LOAD.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonLoad.setOnMouseClicked(e -> {
            buttonLoad.setImage(Constants.getImage(Button.LOAD_CLICK.getPath()));
            buttonClick = new Sounds(SoundsName.BUTTON_CLICK.getSoundName());
            buttonClick.start();
        });
        buttonSettings.setOnMouseEntered(e -> {
            buttonSettings.setImage(Constants.getImage(Button.SETTINGS_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonSettings.setOnMouseExited(e -> {
            buttonSettings.setImage(Constants.getImage(Button.SETTINGS.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonSettings.setOnMouseClicked(e -> {
            buttonSettings.setImage(Constants.getImage(Button.SETTINGS_CLICK.getPath()));
            buttonClick = new Sounds(SoundsName.BUTTON_CLICK.getSoundName());
            buttonClick.start();
        });
//        buttonMenu.setOnMouseEntered(e -> buttonMenu.setImage(Button.MENU_ENTERED.getImage()));
//        buttonMenu.setOnMouseExited(e -> buttonMenu.setImage(Button.MENU.getImage()));
//        buttonMenu.setOnMouseClicked(e -> );
        buttonExit.setOnMouseEntered(e -> {
            buttonExit.setImage(Constants.getImage(Button.EXIT_ENTERED.getPath()));
            buttonEntered = new Sounds(SoundsName.BUTTON_ENTERED.getSoundName());
            buttonEntered.start();
        });
        buttonExit.setOnMouseExited(e -> {
            buttonExit.setImage(Constants.getImage(Button.EXIT.getPath()));
            buttonExited = new Sounds(SoundsName.BUTTON_EXITED.getSoundName());
            buttonExited.start();
        });
        buttonExit.setOnMouseClicked(e -> ((Stage) (SCENE.getWindow())).close());
    }

    class NewGame extends Thread {
        public void run() {
            TIMER.start();
        }
    }
}
